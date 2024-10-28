package com.virtukch.dongiveupbe.quiz.dto;

import com.virtukch.dongiveupbe.quiz.entity.Quiz;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QuizResponseDto {

    private Long quizNum;

    private String category;

    private String type;

    private String answer;

    private String desc;

    public static QuizResponseDto fromEntity(Quiz quiz) {
        return QuizResponseDto.builder()
            .quizNum(quiz.getQuizNum())
            .category(quiz.getCategory())
            .type(quiz.getType())
            .answer(quiz.getAnswer())
            .desc(quiz.getDescription())
            .build();
    }
}