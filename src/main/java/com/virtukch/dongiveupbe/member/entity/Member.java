package com.virtukch.dongiveupbe.member.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
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

    @Builder
    public Member(String memberEmail, String memberPassword, String memberName, String memberSchool,
        LocalDate memberBirthday, String memberNickname, MemberRole memberRole, Integer memberGrade,
        Integer memberClass) {
        this.memberEmail = memberEmail;
        this.memberPassword = memberPassword;
        this.memberName = memberName;
        this.memberSchool = memberSchool;
        this.memberBirthday = memberBirthday;
        this.memberNickname = memberNickname;
        this.memberRole = memberRole;
        this.memberGrade = memberGrade;
        this.memberClass = memberClass;
    }
}