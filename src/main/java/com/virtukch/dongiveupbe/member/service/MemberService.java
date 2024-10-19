package com.virtukch.dongiveupbe.member.service;

import com.virtukch.dongiveupbe.member.dto.MemberRegisterRequestDto;
import com.virtukch.dongiveupbe.member.dto.MemberResponseDto;
import com.virtukch.dongiveupbe.member.entity.Member;
import com.virtukch.dongiveupbe.member.repository.MemberRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public ResponseEntity<Member> save(MemberRegisterRequestDto memberRegisterRequestDto) {
        Member member = Member.builder()
            .memberEmail(memberRegisterRequestDto.getMemberEmail())
            .memberSchool(memberRegisterRequestDto.getMemberSchool())
            .memberName(memberRegisterRequestDto.getMemberName())
            .memberGrade(memberRegisterRequestDto.getMemberGrade())
            .memberClass(memberRegisterRequestDto.getMemberClass())
            .memberNumber(memberRegisterRequestDto.getMemberNumber())
            .build();

        return ResponseEntity.ok(memberRepository.save(member));
    }

    public ResponseEntity<MemberResponseDto> findById(Long memberId) {
        Optional<Member> member = memberRepository.findById(memberId);
        if (member.isPresent()) {
            Member memberEntity = member.get();
            MemberResponseDto memberResponseDto = MemberResponseDto.builder()
                .memberId(memberEntity.getMemberId())
                .memberEmail(memberEntity.getMemberEmail())
                .memberSchool(memberEntity.getMemberSchool())
                .memberName(memberEntity.getMemberName())
                .memberGrade(memberEntity.getMemberGrade())
                .memberClass(memberEntity.getMemberClass())
                .memberNumber(memberEntity.getMemberNumber())
                .build();
            return ResponseEntity.ok(memberResponseDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
