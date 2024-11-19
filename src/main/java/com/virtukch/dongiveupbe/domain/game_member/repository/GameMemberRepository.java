package com.virtukch.dongiveupbe.domain.game_member.repository;

import com.virtukch.dongiveupbe.domain.game_member.dto.GameMemberResponseDto;
import com.virtukch.dongiveupbe.domain.game_member.entity.GameMember;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GameMemberRepository extends JpaRepository<GameMember, Long> {

    List<GameMember> findByMemberId(Long memberId);

    boolean existsByMemberIdAndGameId(Long memberId, Long gameId);

    List<GameMember> findByGameId(Long gameId);
    @Query("SELECT new com.virtukch.dongiveupbe.domain.game_member.dto.GameMemberResponseDto(" +
            "gm.gameMemberId, gm.gameId, gm.memberId, gm.gameMemberMoney) " +
            "FROM GameMember gm " +
            "WHERE gm.memberId = :memberId AND gm.gameId = :gameId")
    Optional<GameMemberResponseDto> findCurrentGameMemberByMemberId(
            @Param("memberId") Long memberId,
            @Param("gameId") Long gameId);
}