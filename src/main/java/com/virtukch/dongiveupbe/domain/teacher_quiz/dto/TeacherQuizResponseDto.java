package com.virtukch.dongiveupbe.domain.teacher_quiz.dto;

import com.virtukch.dongiveupbe.domain.teacher_quiz.entity.TeacherQuiz;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeacherQuizResponseDto {
    private Long teacherQuizId;

    private Long memberId;

    private Long quizId;

    private Integer isStopped;

    public static TeacherQuizResponseDto fromEntity(TeacherQuiz teacherQuiz) {
        return TeacherQuizResponseDto.builder()
                .teacherQuizId(teacherQuiz.getTeacherQuizId())
                .memberId(teacherQuiz.getMemberId())
                .quizId(teacherQuiz.getQuizId())
                .isStopped(teacherQuiz.getIsStopped())
                .build();
    }

}
