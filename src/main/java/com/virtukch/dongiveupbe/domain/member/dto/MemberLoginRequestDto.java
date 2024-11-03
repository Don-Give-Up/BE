package com.virtukch.dongiveupbe.domain.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberLoginRequestDto {

    private String memberEmail;

    private String memberPassword;
}