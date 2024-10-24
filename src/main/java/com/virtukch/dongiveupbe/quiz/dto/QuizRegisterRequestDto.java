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
public class QuizRegisterRequestDto {

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

    public static Quiz toEntity(QuizRegisterRequestDto quizRegisterRequestDto) {
        return Quiz.builder()
            .memberId(quizRegisterRequestDto.getMemberId())
            .unitId(quizRegisterRequestDto.getUnitId())
            .quizTitle(quizRegisterRequestDto.getQuizTitle())
            .quizType(quizRegisterRequestDto.getQuizType())
            .oxQuizAnswer(quizRegisterRequestDto.getOxQuizAnswer())
            .multipleChoiceQuizAnswer(quizRegisterRequestDto.getMultipleChoiceQuizAnswer())
            .subjectiveQuizAnswer(quizRegisterRequestDto.getSubjectiveQuizAnswer())
            .isAcceptedByTeacher(quizRegisterRequestDto.getIsAcceptedByTeacher())
            .createdAt(quizRegisterRequestDto.getCreatedAt())
            .updatedAt(quizRegisterRequestDto.getUpdatedAt())
            .quizLevel(quizRegisterRequestDto.getQuizLevel())
            .build();
    }
}