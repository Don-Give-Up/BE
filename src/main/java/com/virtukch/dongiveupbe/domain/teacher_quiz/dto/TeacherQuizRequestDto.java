package com.virtukch.dongiveupbe.domain.teacher_quiz.dto;

import com.virtukch.dongiveupbe.domain.teacher_quiz.entity.TeacherQuiz;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeacherQuizRequestDto {
    @Hidden
    private Long memberId;

    private Long quizId;

    private Integer isStopped;

    public static TeacherQuiz toEntity(Long memberId, TeacherQuizRequestDto requestDto) {
        return TeacherQuiz.builder()
                .memberId(memberId)
                .quizId(requestDto.getQuizId())
                .isStopped(requestDto.getIsStopped())
                .build();
    }
}
