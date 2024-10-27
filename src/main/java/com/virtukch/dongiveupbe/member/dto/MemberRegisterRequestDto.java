package com.virtukch.dongiveupbe.member.dto;

import com.virtukch.dongiveupbe.member.entity.MemberRole;
import java.time.LocalDate;
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

    private String memberPassword;

    private String memberName;

    private String memberSchool;

    private LocalDate memberDateTime;

    private String memberNickname;

    private MemberRole memberRole;

    private Integer memberGrade;

    private Integer memberClass;
}
