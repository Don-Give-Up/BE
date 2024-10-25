package com.virtukch.dongiveupbe.game_member.repository;

import com.virtukch.dongiveupbe.game_member.entity.GameMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameMemberRepository extends JpaRepository<GameMember, Long> {
}
