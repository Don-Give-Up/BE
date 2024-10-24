package com.virtukch.dongiveupbe.game_member.service;

import com.virtukch.dongiveupbe.game_member.entity.GameMember;
import com.virtukch.dongiveupbe.game_member.repository.GameMemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameMemberService {
    private final GameMemberRepository gameMemberRepository;

    public GameMemberService(GameMemberRepository gameMemberRepository) {
        this.gameMemberRepository = gameMemberRepository;
    }

    @Transactional(readOnly = true)
    public GameMember findById(Long gameMemberId) {
        return gameMemberRepository.findById(gameMemberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 GameMember ID입니다: " + gameMemberId));
    }
}
