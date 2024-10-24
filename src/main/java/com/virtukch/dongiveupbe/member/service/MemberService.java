package com.virtukch.dongiveupbe.member.service;

import com.virtukch.dongiveupbe.member.dto.MemberRegisterRequestDto;
import com.virtukch.dongiveupbe.member.dto.MemberResponseDto;
import com.virtukch.dongiveupbe.member.entity.Member;
import com.virtukch.dongiveupbe.member.exception.MemberNotFoundException;
import com.virtukch.dongiveupbe.member.repository.MemberRepository;
import com.virtukch.dongiveupbe.member.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordUtils passwordUtils;

    @Autowired
    public MemberService(MemberRepository memberRepository, PasswordUtils passwordUtils) {
        this.memberRepository = memberRepository;
        this.passwordUtils = passwordUtils;
    }

    public ResponseEntity<MemberResponseDto> save(
        MemberRegisterRequestDto memberRegisterRequestDto) {
        Member member = Member.builder()
            .memberEmail(memberRegisterRequestDto.getMemberEmail())
            .memberPassword(passwordUtils.hashPassword(memberRegisterRequestDto.getMemberPassword()))
            .memberName(memberRegisterRequestDto.getMemberName())
            .memberSchool(memberRegisterRequestDto.getMemberSchool())
            .memberBirthday(memberRegisterRequestDto.getMemberDateTime())
            .memberNickname(memberRegisterRequestDto.getMemberNickname())
            .memberRole(memberRegisterRequestDto.getMemberRole())
            .memberGrade(memberRegisterRequestDto.getMemberGrade())
            .memberClass(memberRegisterRequestDto.getMemberClass())
            .build();

        Member savedMember = memberRepository.save(member);

        MemberResponseDto memberResponseDto = MemberResponseDto.builder()
            .memberEmail(savedMember.getMemberEmail())
            .memberPassword(savedMember.getMemberPassword())
            .memberName(savedMember.getMemberName())
            .memberSchool(savedMember.getMemberSchool())
            .memberDateTime(savedMember.getMemberBirthday())
            .memberNickname(savedMember.getMemberNickname())
            .memberRole(savedMember.getMemberRole())
            .memberGrade(savedMember.getMemberGrade())
            .memberClass(savedMember.getMemberClass())
            .build();

        return ResponseEntity.ok(memberResponseDto);
    }

    public ResponseEntity<MemberResponseDto> findById(String memberEmail) {
        Member member = memberRepository.findByMemberEmail(memberEmail).orElse(null);

        if (member == null) { // value 가 null 이라면
            throw new MemberNotFoundException(memberEmail + " not found");
        }

        MemberResponseDto memberResponseDto = MemberResponseDto.builder()
            .memberEmail(member.getMemberEmail())
            .memberPassword(member.getMemberPassword())
            .memberName(member.getMemberName())
            .memberSchool(member.getMemberSchool())
            .memberDateTime(member.getMemberBirthday())
            .memberNickname(member.getMemberNickname())
            .memberRole(member.getMemberRole())
            .memberGrade(member.getMemberGrade())
            .memberClass(member.getMemberClass())
            .build();

        return ResponseEntity.ok(memberResponseDto);
    }
}