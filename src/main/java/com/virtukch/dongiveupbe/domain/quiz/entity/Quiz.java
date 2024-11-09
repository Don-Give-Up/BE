package com.virtukch.dongiveupbe.domain.quiz.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@ToString
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quizId;

    private Long memberId;

    private String quizCategory;

    private String quizTitle;

    private String quizType;

    private String quizAnswer;

    @Column(columnDefinition = "TEXT")
    private String quizDescription;

    private String quizLevel;

    private IsAcceptedByTeacher isAcceptedByTeacher;

    private LocalDateTime createdAt;

    private Integer count = 0;

    @Builder
    public Quiz(Long memberId, String quizCategory, String quizTitle, String quizType, String quizAnswer, String quizDescription, String quizLevel, IsAcceptedByTeacher isAcceptedByTeacher, LocalDateTime createdAt, Integer count) {
        this.memberId = memberId;
        this.quizCategory = quizCategory;
        this.quizTitle = quizTitle;
        this.quizType = quizType;
        this.quizAnswer = quizAnswer;
        this.quizDescription = quizDescription;
        this.quizLevel = quizLevel;
        this.isAcceptedByTeacher = isAcceptedByTeacher;
        this.createdAt = createdAt;
        this.count = count;
    }

    public void increaseCount() {
        if (this.count == null) {
            this.count = 0;
        }
        this.count++;
    }

}