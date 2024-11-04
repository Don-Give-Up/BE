package com.virtukch.dongiveupbe.domain.game_member.service;

import com.virtukch.dongiveupbe.domain.game_member.dto.GameMemberRequestDto;
import com.virtukch.dongiveupbe.domain.game_member.dto.GameMemberResponseDto;
import com.virtukch.dongiveupbe.domain.game_member.entity.GameMember;
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
        Optional<GameMember> gameMember = gameMemberRepository.findById(gameMemberId);
        return gameMember.map(GameMemberResponseDto::fromEntity).orElse(null);
    }

    // 3. 회원 아이티로 게임 멤버 아이디 리스트 조회
    public List<GameMemberResponseDto> findByMemberId(Long memberId) {
        List<GameMember> gameMemberList = gameMemberRepository.findByMemberId(memberId);
        return gameMemberList.stream().map(GameMemberResponseDto::fromEntity).toList();
    }

    // 4. 게임 아이디로 게임 내에 있는 게임 멤버 리스트 조회
    public List<GameMemberResponseDto> findByGameId(Long gameId) {
        List<GameMember> gameMemberList = gameMemberRepository.findByGameId(gameId);
        return gameMemberList.stream().map(GameMemberResponseDto::fromEntity).toList();
    }
}
