package com.virtukch.dongiveupbe.security.member.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(unique = true)
    private String memberEmail;

    private String memberPassword;

    private String memberName;

    private String memberSchool;

    private LocalDate memberBirthday;

    private String memberNickname;

    private MemberRole memberRole;

    private Integer memberGrade;

    private Integer memberClass;
}