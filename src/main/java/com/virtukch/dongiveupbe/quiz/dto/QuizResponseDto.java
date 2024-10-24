package com.virtukch.dongiveupbe.quiz.dto;

import com.virtukch.dongiveupbe.quiz.entity.IsAcceptedByTeacher;
import com.virtukch.dongiveupbe.quiz.entity.MultipleChoiceQuizAnswer;
import com.virtukch.dongiveupbe.quiz.entity.OXQuizAnswer;
import com.virtukch.dongiveupbe.quiz.entity.Quiz;
import com.virtukch.dongiveupbe.quiz.entity.QuizType;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QuizResponseDto {

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

    public static QuizResponseDto fromEntity(Quiz quiz) {
        return QuizResponseDto.builder()
            .quizId(quiz.getQuizId())
            .memberId(quiz.getMemberId())
            .unitId(quiz.getUnitId())
            .quizTitle(quiz.getQuizTitle())
            .quizType(quiz.getQuizType())
            .oxQuizAnswer(quiz.getOxQuizAnswer())
            .multipleChoiceQuizAnswer(quiz.getMultipleChoiceQuizAnswer())
            .subjectiveQuizAnswer(quiz.getSubjectiveQuizAnswer())
            .isAcceptedByTeacher(quiz.getIsAcceptedByTeacher())
            .createdAt(quiz.getCreatedAt())
            .updatedAt(quiz.getUpdatedAt())
            .quizLevel(quiz.getQuizLevel())
            .build();
    }
}