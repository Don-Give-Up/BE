package com.virtukch.dongiveupbe.security.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberLoginRequestDto {

    private String memberEmail;

    private String memberPassword;
}