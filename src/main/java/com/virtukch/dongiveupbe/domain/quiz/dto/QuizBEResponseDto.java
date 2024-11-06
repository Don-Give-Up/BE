package com.virtukch.dongiveupbe.domain.quiz.dto;

import com.virtukch.dongiveupbe.domain.quiz.entity.Quiz;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QuizBEResponseDto {
    private Long quizId;
    private Long memberId;
    private String quizCategory;
    private String quizTitle;
    private String quizLevel;
    private LocalDateTime date;
    private Integer count;

    public static QuizBEResponseDto from(Quiz quiz) {
        return QuizBEResponseDto.builder()
                .quizId(quiz.getQuizId())
                .memberId(quiz.getMemberId())
                .quizCategory(quiz.getQuizCategory())
                .quizTitle(quiz.getQuizTitle())
                .quizLevel(quiz.getQuizLevel())
                .date(quiz.getCreatedAt())
                .count(quiz.getCount())
                .build();
    }
}
