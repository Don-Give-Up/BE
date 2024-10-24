package com.virtukch.dongiveupbe.member.service;

import com.virtukch.dongiveupbe.member.dto.MemberRegisterRequestDto;
import com.virtukch.dongiveupbe.member.dto.MemberResponseDto;
import com.virtukch.dongiveupbe.member.entity.Member;
import com.virtukch.dongiveupbe.member.exception.MemberNotFoundException;
import com.virtukch.dongiveupbe.member.repository.MemberRepository;
import com.virtukch.dongiveupbe.member.utils.PasswordUtils;
import java.util.Optional;
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
        Optional<Member> member = memberRepository.findByMemberEmail(memberEmail);

        if (member.isEmpty()) { // value 가 null 이라면
            throw new MemberNotFoundException(memberEmail);
        }

        MemberResponseDto memberResponseDto = MemberResponseDto.builder()
            .memberEmail(member.get().getMemberEmail())
            .memberPassword(member.get().getMemberPassword())
            .memberName(member.get().getMemberName())
            .memberSchool(member.get().getMemberSchool())
            .memberDateTime(member.get().getMemberBirthday())
            .memberNickname(member.get().getMemberNickname())
            .memberRole(member.get().getMemberRole())
            .memberGrade(member.get().getMemberGrade())
            .memberClass(member.get().getMemberClass())
            .build();

        return ResponseEntity.ok(memberResponseDto);
    }
}