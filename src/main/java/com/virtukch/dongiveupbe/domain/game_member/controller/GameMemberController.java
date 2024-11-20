package com.virtukch.dongiveupbe.domain.game_member.controller;

import com.virtukch.dongiveupbe.domain.game_member.dto.GameMemberRequestDto;
import com.virtukch.dongiveupbe.domain.game_member.dto.GameMemberResponseDto;
import com.virtukch.dongiveupbe.domain.game_member.exception.DuplicateGameMemberException;
import com.virtukch.dongiveupbe.domain.game_member.service.GameMemberService;
import com.virtukch.dongiveupbe.security.common.utils.TokenUtils;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/game-members")
@Tag(name = "게임 멤버 API", description = "멤버가 게임에 참여할 때마다 호출하는 API 입니다.")
public class GameMemberController {

    private final GameMemberService gameMemberService;

    @Autowired
    public GameMemberController(GameMemberService gameMemberService) {
        this.gameMemberService = gameMemberService;
    }

    // 1. 게임에 입장하면 게임 멤버 아이디 주기
    @PostMapping
    @Operation(summary = "게임에 멤버가 참여할 때 호출해 주세요", description = "멤버 아이디는 게임에 멤버가 참여할 때, 게임 아이디는 게임이 생성될 때 만들어집니다.")
    public ResponseEntity<GameMemberResponseDto> save(
            @RequestBody GameMemberRequestDto gameMemberRequestDto,
            HttpServletRequest request) {
        Long memberId = TokenUtils.getMemberIdFromRequest(request);
        gameMemberRequestDto.setMemberId(memberId);
        return ResponseEntity.ok(gameMemberService.save(gameMemberRequestDto));
    }

    // 2. 게임 멤버 아이디로 회원 아이디 조회
    @Hidden
    @GetMapping("{gameMemberId}")
    @Operation(summary = "게임 멤버 조회", description = "게임 멤버 아이디를 통해 해당 멤버의 정보를 조회합니다.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "게임 멤버 조회 성공",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = GameMemberResponseDto.class))),
        @ApiResponse(responseCode = "404", description = "해당 게임 멤버를 찾을 수 없음",
            content = @Content)
    })
    public ResponseEntity<GameMemberResponseDto> findById(@PathVariable Long gameMemberId) {
        return ResponseEntity.ok(gameMemberService.findById(gameMemberId));
    }

    // 3. 회원 아이디로 게임 멤버 아이디 리스트 조회
    @Hidden
    @GetMapping("member/{memberId}")
    @Operation(summary = "회원 아이디로 게임 멤버 조회", description = "회원 아이디를 통해 해당 회원의 게임 멤버 리스트를 조회합니다.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "게임 멤버 리스트 조회 성공",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = GameMemberResponseDto.class))),
        @ApiResponse(responseCode = "404", description = "해당 회원의 게임 멤버를 찾을 수 없음",
            content = @Content)
    })
    public ResponseEntity<GameMemberResponseDto> findByMemberId(@PathVariable Long memberId) {
        return ResponseEntity.ok(gameMemberService.findByMemberId(memberId));
    }

    // 4. 게임 아이디로 게임 내에 있는 게임 멤버 리스트 조회
    @GetMapping("game/{gameId}")
    @Operation(summary = "게임 아이디로 게임 멤버 조회", description = "게임 아이디를 통해 해당 게임의 멤버 리스트를 조회합니다.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "게임 멤버 리스트 조회 성공",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = GameMemberResponseDto.class))),
        @ApiResponse(responseCode = "404", description = "해당 게임의 멤버를 찾을 수 없음",
            content = @Content)
    })
    public ResponseEntity<List<GameMemberResponseDto>> findGameMembersByGameId(@PathVariable Long gameId) {
        List<GameMemberResponseDto> gameMembers = gameMemberService.findGameMembersByGameId(gameId);
        return ResponseEntity.ok(gameMembers);
    }
}