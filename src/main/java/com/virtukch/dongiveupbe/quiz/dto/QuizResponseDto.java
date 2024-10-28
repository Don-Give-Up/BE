package com.virtukch.dongiveupbe.quiz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.virtukch.dongiveupbe.quiz.entity.Quiz;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"quizNum", "category", "quiz", "type", "answer", "desc", "level"}) // 원하는 순서 지정
public class QuizResponseDto {

    @JsonProperty(value = "quizNum")
    private Long quizId;

    @JsonProperty(value = "category")
    private String quizCategory;

    @JsonProperty(value = "quiz")
    private String quizTitle;

    @JsonProperty(value = "type")
    private String quizType;

    @JsonProperty(value = "answer")
    private String quizAnswer;

    @JsonProperty(value = "desc")
    private String quizDescription;

    private String quizLevel;

    public static QuizResponseDto fromEntity(Quiz quiz) {
        return QuizResponseDto.builder()
            .quizId(quiz.getQuizId())
            .quizCategory(quiz.getQuizCategory())
            .quizTitle(quiz.getQuizTitle())
            .quizType(quiz.getQuizType())
            .quizAnswer(quiz.getQuizAnswer())
            .quizDescription(quiz.getQuizDescription())
            .quizLevel(quiz.getQuizLevel())
            .build();
    }
}