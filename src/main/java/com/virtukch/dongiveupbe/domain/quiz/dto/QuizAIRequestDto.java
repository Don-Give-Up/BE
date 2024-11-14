package com.virtukch.dongiveupbe.domain.quiz.dto;

import com.virtukch.dongiveupbe.domain.quiz.entity.IsAcceptedByTeacher;
import com.virtukch.dongiveupbe.domain.quiz.entity.Quiz;
import io.swagger.v3.oas.annotations.Hidden;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuizAIRequestDto {

    private String quizCategory;

    private String quizTitle;

    private String quizType;

    private String quizAnswer;

    private String quizDescription;

    private String quizLevel;
    @Hidden
    private Integer count;

    public static Quiz toEntity(QuizAIRequestDto quizAIRequestDto) {
        return Quiz.builder()
            .memberId(7L)
            .quizCategory(quizAIRequestDto.getQuizCategory())
            .quizTitle(quizAIRequestDto.getQuizTitle())
            .quizType(quizAIRequestDto.getQuizType())
            .quizAnswer(quizAIRequestDto.getQuizAnswer())
            .quizDescription(quizAIRequestDto.getQuizDescription())
            .quizLevel(quizAIRequestDto.getQuizLevel())
            .isAcceptedByTeacher(IsAcceptedByTeacher.ACCEPTED_BY_TEACHER)
            .createdAt(LocalDateTime.now())
            .count(0)
            .build();
    }

    public static Quiz toEntity(QuizAIRequestDto quizAIRequestDto, long memberId) {
        return Quiz.builder()
            .memberId(memberId)
            .quizCategory(quizAIRequestDto.getQuizCategory())
            .quizTitle(quizAIRequestDto.getQuizTitle())
            .quizType(quizAIRequestDto.getQuizType())
            .quizAnswer(quizAIRequestDto.getQuizAnswer())
            .quizDescription(quizAIRequestDto.getQuizDescription())
            .quizLevel(quizAIRequestDto.getQuizLevel())
            .isAcceptedByTeacher(IsAcceptedByTeacher.ACCEPTED_BY_TEACHER)
            .createdAt(LocalDateTime.now())
            .count(0)
            .build();
    }
}