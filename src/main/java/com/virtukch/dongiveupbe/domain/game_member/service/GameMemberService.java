package com.virtukch.dongiveupbe.domain.game_member.service;

import com.virtukch.dongiveupbe.domain.essential_product.exception.EntityNotFoundException;
import com.virtukch.dongiveupbe.domain.game_member.dto.GameMemberRequestDto;
import com.virtukch.dongiveupbe.domain.game_member.dto.GameMemberResponseDto;
import com.virtukch.dongiveupbe.domain.game_member.entity.GameMember;
import com.virtukch.dongiveupbe.domain.game_member.exception.DuplicateGameMemberException;
import com.virtukch.dongiveupbe.domain.game_member.repository.GameMemberRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameMemberService {

    private final GameMemberRepository gameMemberRepository;

    @Autowired
    public GameMemberService(GameMemberRepository gameMemberRepository) {
        this.gameMemberRepository = gameMemberRepository;
    }

    // 1. 게임에 입장하면 게임 멤버 아이디 주기
    public GameMemberResponseDto save(GameMemberRequestDto gameMemberRequestDto) {

        GameMember gameMember = GameMemberRequestDto.toEntity(gameMemberRequestDto);
        gameMember = gameMemberRepository.save(gameMember);
        return GameMemberResponseDto.fromEntity(gameMember);
    }

    // 2. 게임 멤버 아이디로 회원 아이디 조회
    public GameMemberResponseDto findById(Long gameMemberId) {
        return gameMemberRepository.findById(gameMemberId)
                .map(GameMemberResponseDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("게임 멤버를 찾을 수 없습니다. ID: " + gameMemberId));
    }

    // 3. 회원 아이티로 게임 멤버 아이디 리스트 조회
    public GameMemberResponseDto findByMemberId(Long memberId) {
        return gameMemberRepository.findByMemberId(memberId).stream()
                .findFirst()
                .map(GameMemberResponseDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("게임 멤버를 찾을 수 없습니다. memberId: " + memberId));
    }


    // 4. 게임 아이디로 게임 내에 있는 게임 멤버 리스트 조회
    public GameMemberResponseDto findCurrentGameMemberByMemberId(Long memberId, Long gameId) {
        return gameMemberRepository.findByMemberId(memberId).stream()
                .filter(gameMember -> gameMember.getGameId().equals(gameId))
                .findFirst()
                .map(GameMemberResponseDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("현재 게임에 참여 중인 멤버를 찾을 수 없습니다. memberId: " + memberId));
    }

    public boolean isMemberAlreadyInGame(Long memberId, Long gameId) {
        return gameMemberRepository.findByMemberId(memberId).stream()
                .anyMatch(gameMember -> gameMember.getGameId().equals(gameId));
    }

}
