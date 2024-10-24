package com.virtukch.dongiveupbe.game.repository;

import com.virtukch.dongiveupbe.game.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
