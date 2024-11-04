package com.virtukch.dongiveupbe.domain.game_member.repository;

import com.virtukch.dongiveupbe.domain.game_member.entity.GameMember;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameMemberRepository extends JpaRepository<GameMember, Long> {

    List<GameMember> findByMemberId(Long memberId);

    List<GameMember> findByGameId(Long gameId);
}