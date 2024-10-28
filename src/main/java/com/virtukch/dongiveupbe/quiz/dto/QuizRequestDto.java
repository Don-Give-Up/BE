package com.virtukch.dongiveupbe.quiz.dto;

import com.virtukch.dongiveupbe.quiz.entity.IsAcceptedByTeacher;
import com.virtukch.dongiveupbe.quiz.entity.Quiz;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuizRequestDto {

    // 퀴즈를 생성하는 사람은 AI 혹은 Web 내의 선생님

    private Long memberId; // AI 는 memberId 가 null, 선생님은 토큰에 가지고 있음.

    private String quizCategory; // 필수 등록

    private String quizTitle; // 필수 등록

    private String quizType; // 필수 등록

    private String quizAnswer; // 필수 등록

    private String quizDescription; // 필수 등록

    private String quizLevel; // 필수 등록

    public static Quiz toEntity(QuizRequestDto quizRequestDto) {

        return Quiz.builder()
            .memberId(quizRequestDto.getMemberId())
            .quizCategory(quizRequestDto.getQuizCategory())
            .quizTitle(quizRequestDto.getQuizTitle())
            .quizType(quizRequestDto.getQuizType())
            .quizAnswer(quizRequestDto.getQuizAnswer())
            .quizDescription(quizRequestDto.getQuizDescription())
            .quizLevel(quizRequestDto.getQuizLevel())
            .isAcceptedByTeacher(quizRequestDto.memberId == null ? IsAcceptedByTeacher.NOT_ACCEPTED_BY_TEACHER : IsAcceptedByTeacher.ACCEPTED_BY_TEACHER)
            .createdAt(LocalDateTime.now())
            .build();
    }
}