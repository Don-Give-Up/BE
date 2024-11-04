package com.virtukch.dongiveupbe.domain.game.repository;

import com.virtukch.dongiveupbe.domain.game.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
