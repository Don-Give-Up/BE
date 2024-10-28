package com.virtukch.dongiveupbe.quiz.dto;

import com.virtukch.dongiveupbe.member.utils.PasswordUtils;
import com.virtukch.dongiveupbe.quiz.entity.IsAcceptedByTeacher;
import com.virtukch.dongiveupbe.quiz.entity.Quiz;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
public class QuizRequestDto {

    private Long memberId;                  // XR 에게 보내지 않을 정보

    private String category;

    private String type;

    private String answer;

    private String desc;

    private IsAcceptedByTeacher isAcceptedByTeacher;     // XR 에게 보내지 않을 정보

    private LocalDateTime createdAt;        // XR 에게 보내지 않을 정보

    private LocalDateTime updatedAt;        // XR 에게 보내지 않을 정보

    public static Quiz toEntity(QuizRequestDto quizRequestDto) {

        Quiz quiz = Quiz.builder()
            .memberId(quizRequestDto.getMemberId())
            .category(quizRequestDto.getCategory())
            .type(quizRequestDto.getType())
            .answer(quizRequestDto.getAnswer())
            .desc(quizRequestDto.getDesc())
            .isAcceptedByTeacher(quizRequestDto.getIsAcceptedByTeacher())
            .createdAt(LocalDateTime.now())
            .updatedAt(null)
            .build();

        if (quizRequestDto.getMemberId() == null) {
            quiz.setIsAcceptedByTeacher(IsAcceptedByTeacher.NOT_ACCEPTED_BY_TEACHER);
        } else {
            quiz.setIsAcceptedByTeacher(IsAcceptedByTeacher.ACCEPTED_BY_TEACHER);
        }

        return quiz;
    }
}