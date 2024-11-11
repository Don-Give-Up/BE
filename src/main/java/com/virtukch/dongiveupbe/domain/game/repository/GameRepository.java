package com.virtukch.dongiveupbe.domain.game.repository;

import com.virtukch.dongiveupbe.domain.game.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Long> {
    Optional<Game> findById(Long gameId);
}
