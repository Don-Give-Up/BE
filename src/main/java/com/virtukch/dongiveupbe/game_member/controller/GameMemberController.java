package com.virtukch.dongiveupbe.game_member.controller;

import com.virtukch.dongiveupbe.game_member.dto.GameMemberRegisterRequestDto;
import com.virtukch.dongiveupbe.game_member.dto.GameMemberResponseDto;
import com.virtukch.dongiveupbe.game_member.service.GameMemberService;
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
@RequestMapping("api/v1/game-members")
public class GameMemberController {

    private final GameMemberService gameMemberService;

    @Autowired
    public GameMemberController(GameMemberService gameMemberService) {
        this.gameMemberService = gameMemberService;
    }

    // 1. 게임에 입장하면 게임 멤버 아이디 주기
    @PostMapping
    public ResponseEntity<GameMemberResponseDto> save(
        @RequestBody GameMemberRegisterRequestDto gameMemberRegisterRequestDto) {
        return ResponseEntity.ok(gameMemberService.save(gameMemberRegisterRequestDto));
    }

    // 2. 게임 멤버 아이디로 회원 아이디 조회
    @GetMapping("{gameMemberId}")
    public ResponseEntity<GameMemberResponseDto> findById(@PathVariable Long gameMemberId) {
        return ResponseEntity.ok(gameMemberService.findById(gameMemberId));
    }

    // 3. 회원 아이티로 게임 멤버 아이디 리스트 조회
    @GetMapping("{memberId}")
    public ResponseEntity<List<GameMemberResponseDto>> findByMemberId(@PathVariable Long memberId) {
        return ResponseEntity.ok(gameMemberService.findByMemberId(memberId));
    }

    // 4. 게임 아이디로 게임 내에 있는 게임 멤버 리스트 조회
    @GetMapping("{gameId}")
    public ResponseEntity<List<GameMemberResponseDto>> findByGameId(@PathVariable Long gameId) {
        return ResponseEntity.ok(gameMemberService.findByGameId(gameId));
    }
}