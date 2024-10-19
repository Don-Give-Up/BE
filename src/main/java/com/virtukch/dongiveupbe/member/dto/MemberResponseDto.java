package com.virtukch.dongiveupbe.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponseDto {

    private Long memberId;
    private String memberEmail;
    private String memberSchool;
    private String memberName;
    private Integer memberGrade;
    private Integer memberClass;
    private Integer memberNumber;
}