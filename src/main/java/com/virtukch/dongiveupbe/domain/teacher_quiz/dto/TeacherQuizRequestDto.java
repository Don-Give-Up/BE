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

    private Long gameId;

    private Integer isStopped;

    public static TeacherQuiz toEntity(Long memberId, TeacherQuizRequestDto requestDto) {
        System.out.println("toEntity gameId: " + requestDto.getGameId());
        return TeacherQuiz.builder()
                .memberId(memberId)
                .quizId(requestDto.getQuizId())
                .gameId(requestDto.getGameId())
                .isStopped(requestDto.getIsStopped())
                .build();
    }
}
