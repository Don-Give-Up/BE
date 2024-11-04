package com.virtukch.dongiveupbe.security.member.dto;

import com.virtukch.dongiveupbe.security.member.entity.Member;
import com.virtukch.dongiveupbe.security.member.entity.MemberRole;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequestDto {

    private String memberEmail;

    @Setter
    private String memberPassword;

    private String memberName;

    private String memberSchool;

    private LocalDate memberBirthDay;

    private String memberNickname;

    private MemberRole memberRole;

    private Integer memberGrade;

    private Integer memberClass;

    public static Member toEntity(MemberRequestDto memberRequestDto) {
        return Member.builder()
            .memberEmail(memberRequestDto.getMemberEmail())
            .memberPassword(memberRequestDto.getMemberPassword())
            .memberName(memberRequestDto.getMemberName())
            .memberSchool(memberRequestDto.getMemberSchool())
            .memberBirthday(memberRequestDto.getMemberBirthDay())
            .memberNickname(memberRequestDto.getMemberNickname())
            .memberRole(memberRequestDto.getMemberRole())
            .memberGrade(memberRequestDto.getMemberGrade())
            .memberClass(memberRequestDto.getMemberClass())
            .build();
    }
}