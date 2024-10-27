package com.virtukch.dongiveupbe.quiz.dto;

import com.virtukch.dongiveupbe.quiz.entity.IsAcceptedByTeacher;
import com.virtukch.dongiveupbe.quiz.entity.MultipleChoiceQuizAnswer;
import com.virtukch.dongiveupbe.quiz.entity.OXQuizAnswer;
import com.virtukch.dongiveupbe.quiz.entity.Quiz;
import com.virtukch.dongiveupbe.quiz.entity.QuizType;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class QuizRequestDto {

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

    public static Quiz toEntity(QuizRequestDto quizRequestDto) {
        return Quiz.builder()
            .memberId(quizRequestDto.getMemberId())
            .unitId(quizRequestDto.getUnitId())
            .quizTitle(quizRequestDto.getQuizTitle())
            .quizType(quizRequestDto.getQuizType())
            .oxQuizAnswer(quizRequestDto.getOxQuizAnswer())
            .multipleChoiceQuizAnswer(quizRequestDto.getMultipleChoiceQuizAnswer())
            .subjectiveQuizAnswer(quizRequestDto.getSubjectiveQuizAnswer())
            .isAcceptedByTeacher(quizRequestDto.getIsAcceptedByTeacher())
            .createdAt(quizRequestDto.getCreatedAt())
            .updatedAt(quizRequestDto.getUpdatedAt())
            .quizLevel(quizRequestDto.getQuizLevel())
            .build();
    }
}