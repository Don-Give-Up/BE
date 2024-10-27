package com.virtukch.dongiveupbe.member.service;

import com.virtukch.dongiveupbe.member.dto.MemberLoginRequestDto;
import com.virtukch.dongiveupbe.member.dto.MemberRequestDto;
import com.virtukch.dongiveupbe.member.dto.MemberResponseDto;
import com.virtukch.dongiveupbe.member.entity.Member;
import com.virtukch.dongiveupbe.member.exception.MemberNotFoundException;
import com.virtukch.dongiveupbe.member.exception.PasswordNotEqualsException;
import com.virtukch.dongiveupbe.member.repository.MemberRepository;
import com.virtukch.dongiveupbe.member.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 1. 회원 생성 (회원가입)
    public MemberResponseDto save(MemberRequestDto memberRequestDto) {
        Member savedMember = memberRepository.save(MemberRequestDto.toEntity(memberRequestDto));
        return MemberResponseDto.fromEntity(savedMember);
    }

    // 2. 로그인
    public MemberResponseDto login(MemberLoginRequestDto memberLoginRequestDto) {
        Member member = memberRepository.findByMemberEmail(memberLoginRequestDto.getMemberEmail())
            .orElseThrow(() -> new MemberNotFoundException("해당하는 이메일과 일치하는 Member 가 존재하지 않습니다."));
        if (member.getMemberPassword()
            .equals(PasswordUtils.hashPassword(memberLoginRequestDto.getMemberPassword()))) {
            return MemberResponseDto.fromEntity(member);
        } else {
            throw new PasswordNotEqualsException("비밀번호가 일치하지 않습니다.");
        }
    }

    // 3. 회원 아이디로 회원 찾기
    public MemberResponseDto findById(Long memberId) {
        Member member = memberRepository.findById(memberId)
            .orElseThrow(
                () -> new MemberNotFoundException("해당하는 멤버의 아이디와 일치하는 Member 가 존재하지 않습니다."));
        return MemberResponseDto.fromEntity(member);
    }

    // 4. 회원 이메일로 회원 찾기
    public MemberResponseDto findByMemberEmail(String memberEmail) {
        Member member = memberRepository.findByMemberEmail(memberEmail)
            .orElseThrow(() -> new MemberNotFoundException("해당하는 이메일과 일치하는 Member 가 존재하지 않습니다."));
        return MemberResponseDto.fromEntity(member);
    }
}