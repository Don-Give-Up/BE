package com.virtukch.dongiveupbe.member.dto;

import com.virtukch.dongiveupbe.member.entity.Member;
import com.virtukch.dongiveupbe.member.entity.MemberRole;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponseDto {

    private String memberEmail;

    private String memberPassword;

    private String memberName;

    private String memberSchool;

    private LocalDate memberBirthday;

    private String memberNickname;

    private MemberRole memberRole;

    private Integer memberGrade;

    private Integer memberClass;

    public static MemberResponseDto fromEntity(Member member) {
        return MemberResponseDto.builder()
            .memberEmail(member.getMemberEmail())
            .memberPassword(member.getMemberPassword())
            .memberName(member.getMemberName())
            .memberSchool(member.getMemberSchool())
            .memberBirthday(member.getMemberBirthday())
            .memberNickname(member.getMemberNickname())
            .memberRole(member.getMemberRole())
            .memberGrade(member.getMemberGrade())
            .memberClass(member.getMemberClass())
            .build();
    }
}