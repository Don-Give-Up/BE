package com.virtukch.dongiveupbe.security.member.controller;

import com.virtukch.dongiveupbe.security.common.AuthConstants;
import com.virtukch.dongiveupbe.security.common.utils.TokenUtils;
import com.virtukch.dongiveupbe.security.member.dto.MemberLoginRequestDto;
import com.virtukch.dongiveupbe.security.member.dto.MemberRequestDto;
import com.virtukch.dongiveupbe.security.member.dto.MemberResponseDto;
import com.virtukch.dongiveupbe.security.member.entity.Member;
import com.virtukch.dongiveupbe.security.member.service.MemberService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "회원 가입을 할 때 호출해 주세요", description = "memberRole 은 `STUDENT` 외에는 안 되게 조치해 주세요.")
    public ResponseEntity<MemberResponseDto> save(
        @RequestBody MemberRequestDto memberRequestDto) {
        return ResponseEntity.ok(memberService.save(memberRequestDto));
    }

    // 2. 회원 로그인
    @PostMapping("/login")
    @Operation(summary = "로그인 하실 때 호출해 주세요", description = "응답으로 memberId 를 얻을 수 있습니다. 추후 토큰 방식으로 변경될 예정입니다.")
    public String login(@RequestBody MemberLoginRequestDto memberLoginRequestDto) {

        MemberResponseDto memberResponseDto = memberService.login(memberLoginRequestDto);
        Member member = Member.builder()
            .memberId(memberResponseDto.getMemberId())
            .memberEmail(memberResponseDto.getMemberEmail())
            .memberName(memberResponseDto.getMemberName())
            .memberSchool(memberResponseDto.getMemberSchool())
            .memberBirthday(memberResponseDto.getMemberBirthday())
            .memberNickname(memberResponseDto.getMemberNickname())
            .memberRole(memberResponseDto.getMemberRole())
            .memberGrade(memberResponseDto.getMemberGrade())
            .memberClass(memberResponseDto.getMemberClass())
            .build();

        // 2. 이런 정보를 돌려 주라
        return AuthConstants.AUTH_HEADER_PREFIX + TokenUtils.generateJwtToken(member);
    }

    // 3. 회원 아이디로 회원 찾기
    @Hidden
    @GetMapping("{memberId}")
    public ResponseEntity<MemberResponseDto> findById(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.findById(memberId));
    }

    // 4. 회원 이메일로 회원 찾기
    @Hidden
    @GetMapping("email/{memberEmail}")
    public ResponseEntity<MemberResponseDto> findByEmail(@PathVariable String memberEmail) {
        return ResponseEntity.ok(memberService.findByMemberEmail(memberEmail));
    }

    // Id로 nickname 찾기
    @GetMapping("{memberId}/nickname")
    public ResponseEntity<String> getMemberNickname(@PathVariable Long memberId) {
        MemberResponseDto member = memberService.findById(memberId);
        return ResponseEntity.ok(member.getMemberNickname());
    }

}
