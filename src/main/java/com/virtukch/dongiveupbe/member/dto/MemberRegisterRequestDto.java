package com.virtukch.dongiveupbe.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberRegisterRequestDto {
    private String memberEmail;
    private String memberSchool;
    private String memberName;
    private Integer memberGrade;
    private Integer memberClass;
    private Integer memberNumber;
}
