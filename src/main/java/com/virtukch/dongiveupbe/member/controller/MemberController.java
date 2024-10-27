package com.virtukch.dongiveupbe.member.controller;

import com.virtukch.dongiveupbe.member.dto.MemberLoginRequestDto;
import com.virtukch.dongiveupbe.member.dto.MemberRequestDto;
import com.virtukch.dongiveupbe.member.dto.MemberResponseDto;
import com.virtukch.dongiveupbe.member.service.MemberService;
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

    // 1. 회원 생성 (회원가입)
    @PostMapping("/register")
    public ResponseEntity<MemberResponseDto> save(
        @RequestBody MemberRequestDto memberRequestDto) {
        return ResponseEntity.ok(memberService.save(memberRequestDto));
    }

    // 2. 회원 로그인
    @PostMapping("/login")
    public ResponseEntity<MemberResponseDto> login(@RequestBody MemberLoginRequestDto memberLoginRequestDto) {
        return ResponseEntity.ok(memberService.login(memberLoginRequestDto));
    }

    // 3. 회원 아이디로 회원 찾기
    @GetMapping("{memberId}")
    public ResponseEntity<MemberResponseDto> findById(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.findById(memberId));
    }

    // 4. 회원 이메일로 회원 찾기
    @GetMapping("{memberEmail}")
    public ResponseEntity<MemberResponseDto> findByEmail(@PathVariable String memberEmail) {
        return ResponseEntity.ok(memberService.findByMemberEmail(memberEmail));
    }
}





















