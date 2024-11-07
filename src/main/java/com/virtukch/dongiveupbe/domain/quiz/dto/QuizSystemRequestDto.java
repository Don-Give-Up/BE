package com.virtukch.dongiveupbe.domain.quiz.dto;

import com.virtukch.dongiveupbe.domain.quiz.entity.IsAcceptedByTeacher;
import com.virtukch.dongiveupbe.domain.quiz.entity.Quiz;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QuizSystemRequestDto {

    private String quizCategory;

    private String quizTitle;

    private String quizType;

    private String quizAnswer;

    private String quizDescription;

    private String quizLevel;

    public static Quiz toEntity(QuizSystemRequestDto quizSystemRequestDto) {
        return Quiz.builder()
            .memberId(1L)
            .quizCategory(quizSystemRequestDto.getQuizCategory())
            .quizTitle(quizSystemRequestDto.getQuizTitle())
            .quizType(quizSystemRequestDto.getQuizType())
            .quizAnswer(quizSystemRequestDto.getQuizAnswer())
            .quizDescription(quizSystemRequestDto.getQuizDescription())
            .quizLevel(quizSystemRequestDto.getQuizLevel())
            .isAcceptedByTeacher(IsAcceptedByTeacher.ACCEPTED_BY_TEACHER)
            .createdAt(LocalDateTime.now())
            .build();
    }
}