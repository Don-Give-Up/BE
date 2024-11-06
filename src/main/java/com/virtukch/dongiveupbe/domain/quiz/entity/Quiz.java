package com.virtukch.dongiveupbe.domain.quiz.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

import lombok.*;

@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
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

    private String quizDescription;

    private String quizLevel;

    private IsAcceptedByTeacher isAcceptedByTeacher;

    private LocalDateTime createdAt;

    private Integer count = 0;

    public Quiz(String quizCategory, String quizTitle, String quizType, String quizLevel, String quizAnswer, String quizDescription, Long memberId) {
    }

    public void increaseCount() {
        if (this.count == null) {
            this.count = 0;
        }
        this.count++;
    }

}