package com.virtukch.dongiveupbe.quiz.dto;

import com.virtukch.dongiveupbe.quiz.entity.Quiz;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuizResponseDto {

    private String quizCategory;

    private String quizTitle;

    private String quizType;

    private String quizAnswer;

    private String quizDescription;

    private String quizLevel;

    public static QuizResponseDto fromEntity(Quiz quiz) {
        return QuizResponseDto.builder()
            .quizCategory(quiz.getQuizCategory())
            .quizTitle(quiz.getQuizTitle())
            .quizType(quiz.getQuizType())
            .quizAnswer(quiz.getQuizAnswer())
            .quizDescription(quiz.getQuizDescription())
            .quizLevel(quiz.getQuizLevel())
            .build();
    }
}