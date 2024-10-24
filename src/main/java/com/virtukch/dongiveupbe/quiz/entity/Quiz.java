package com.virtukch.dongiveupbe.quiz.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quizId;

    private Long memberId;

    private Long unitId;

    private String quizTitle;

    private QuizType quizType;

    private OXQuizAnswer oxQuizAnswer;

    private MultipleChoiceQuizAnswer multipleChoiceQuizAnswer;

    private String subjectiveQuizAnswer;

    private IsAcceptedByTeacher isAcceptedByTeacher;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Long quizLevel;

    @Builder
    public Quiz(Long memberId, Long unitId, String quizTitle, QuizType quizType,
        OXQuizAnswer oxQuizAnswer, MultipleChoiceQuizAnswer multipleChoiceQuizAnswer,
        String subjectiveQuizAnswer, IsAcceptedByTeacher isAcceptedByTeacher,
        LocalDateTime createdAt,
        LocalDateTime updatedAt, Long quizLevel) {
        this.memberId = memberId;
        this.unitId = unitId;
        this.quizTitle = quizTitle;
        this.quizType = quizType;
        this.oxQuizAnswer = oxQuizAnswer;
        this.multipleChoiceQuizAnswer = multipleChoiceQuizAnswer;
        this.subjectiveQuizAnswer = subjectiveQuizAnswer;
        this.isAcceptedByTeacher = isAcceptedByTeacher;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.quizLevel = quizLevel;
    }
}