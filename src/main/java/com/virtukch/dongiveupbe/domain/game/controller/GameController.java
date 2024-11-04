package com.virtukch.dongiveupbe.domain.game.controller;

import com.virtukch.dongiveupbe.domain.game.dto.GameResponseDto;
import com.virtukch.dongiveupbe.domain.game.dto.GameRequestDto;
import com.virtukch.dongiveupbe.domain.game.service.GameService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/games")
@Tag(name = "게임 API")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    @Operation(summary = "새로운 게임을 생성할 때 호출해 주세요", description = "호출 이후, 게임 아이디를 받을 수 있습니다.")
    public ResponseEntity<GameResponseDto> saveGame(@RequestBody GameRequestDto requestDto) {
        GameResponseDto responseDto = gameService.saveGame(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @Hidden
    @GetMapping("/{gameId}")
    @Operation(summary = "특정 게임 조회", description = "특정 게임을 ID로 조회합니다.")
    @ApiResponse(responseCode = "200", description = "게임이 성공적으로 조회되었습니다.")
    @ApiResponse(responseCode = "404", description = "게임을 찾을 수 없습니다.")
    public ResponseEntity<GameResponseDto> getGame(@PathVariable Long gameId) {
        GameResponseDto responseDto = gameService.getGame(gameId);
        return ResponseEntity.ok(responseDto);
    }

    @Hidden
    @GetMapping
    @Operation(summary = "전체 게임 조회", description = "등록된 모든 게임을 조회합니다.")
    @ApiResponse(responseCode = "200", description = "전체 게임이 성공적으로 조회되었습니다.")
    public ResponseEntity<List<GameResponseDto>> getAllGames() {
        List<GameResponseDto> responseDtos = gameService.getAllGames();
        return ResponseEntity.ok(responseDtos);
    }
}
