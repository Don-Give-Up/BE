package com.virtukch.dongiveupbe.game.controller;

import com.virtukch.dongiveupbe.game.dto.GameRequestDto;
import com.virtukch.dongiveupbe.game.dto.GameResponseDto;
import com.virtukch.dongiveupbe.game.service.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/games")
@Tag(name = "게임 API", description = "게임 관리를 위한 API")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    @Operation(summary = "게임 저장", description = "새로운 게임을 저장합니다.")
    public ResponseEntity<GameResponseDto> saveGame(@RequestBody GameRequestDto requestDto) {
        GameResponseDto responseDto = gameService.saveGame(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/{gameId}")
    @Operation(summary = "특정 게임 조회", description = "특정 게임을 ID로 조회합니다.")
    public ResponseEntity<GameResponseDto> getGame(@PathVariable Long gameId) {
        GameResponseDto responseDto = gameService.getGame(gameId);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    @Operation(summary = "전체 게임 조회", description = "등록된 모든 게임을 조회합니다.")
    public ResponseEntity<List<GameResponseDto>> getAllGames() {
        List<GameResponseDto> responseDtos = gameService.getAllGames();
        return ResponseEntity.ok(responseDtos);
    }
}
