package com.virtukch.dongiveupbe.member.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private String memberEmail;
    private String memberSchool;
    private String memberName;
    private Integer memberGrade;
    private Integer memberClass;
    private Integer memberNumber;

    @Builder
    public Member(String memberEmail, String memberSchool, String memberName, Integer memberGrade, Integer memberClass, Integer memberNumber) {
        this.memberEmail = memberEmail;
        this.memberSchool = memberSchool;
        this.memberName = memberName;
        this.memberGrade = memberGrade;
        this.memberClass = memberClass;
        this.memberNumber = memberNumber;
    }
}