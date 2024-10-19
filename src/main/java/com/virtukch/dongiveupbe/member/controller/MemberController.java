package com.virtukch.dongiveupbe.member.controller;

import com.virtukch.dongiveupbe.member.dto.MemberRegisterRequestDto;
import com.virtukch.dongiveupbe.member.dto.MemberResponseDto;
import com.virtukch.dongiveupbe.member.entity.Member;
import com.virtukch.dongiveupbe.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 생성
    @PostMapping
    public ResponseEntity<Member> save(@RequestBody MemberRegisterRequestDto memberRegisterRequestDto) {
        return memberService.save(memberRegisterRequestDto);
    }

    // 조회
    @GetMapping("{memberId}")
    public ResponseEntity<MemberResponseDto> findById(@PathVariable Long memberId) {
        return memberService.findById(memberId);
    }

    // 이메일로 조회

    // 이름으로 조회 (List<>)

    // 학교 및 이름으로 조회 (List<>)
}