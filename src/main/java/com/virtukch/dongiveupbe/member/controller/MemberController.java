package com.virtukch.dongiveupbe.member.controller;

import com.virtukch.dongiveupbe.member.dto.MemberRegisterRequestDto;
import com.virtukch.dongiveupbe.member.dto.MemberResponseDto;
import com.virtukch.dongiveupbe.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/members")
@Tag(name = "회원 API", description = "회원가입 / 로그인 등을 위한 멤버 관리용 API")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 회원 생성 (회원가입)
    @PostMapping
    @Operation(summary = "회원 생성 (회원가입)")
    @ApiResponse(responseCode = "200", description = "회원 가입 성공",
        content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = MemberResponseDto.class)))
    public ResponseEntity<MemberResponseDto> save(
        @RequestBody MemberRegisterRequestDto memberRegisterRequestDto) {
        return memberService.save(memberRegisterRequestDto);
    }

    // 이메일을 통한 회원 조회
    @GetMapping("{memberEmail}")
    @Operation(summary = "특정 이메일을 가진 회원 조회")
    @ApiResponse(responseCode = "200", description = "회원 조회 성공",
        content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = MemberResponseDto.class)))
    public ResponseEntity<MemberResponseDto> findById(@PathVariable String memberEmail) {
        return memberService.findById(memberEmail);
    }
}