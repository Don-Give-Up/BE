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
        Member savedMember = memberRepository.save(
            MemberRegisterRequestDto.toEntity(memberRegisterRequestDto));

        return ResponseEntity.ok(MemberResponseDto.fromEntity(savedMember));
    }

    public ResponseEntity<MemberResponseDto> findById(String memberEmail) {
        Member member = memberRepository.findByMemberEmail(memberEmail).orElse(null);

        if (member == null) { // value 가 null 이라면
            throw new MemberNotFoundException(memberEmail + " not found");
        }

        return ResponseEntity.ok(MemberResponseDto.fromEntity(member));
    }
}