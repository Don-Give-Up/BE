package com.virtukch.dongiveupbe.domain.quiz_comment.dto;

import com.virtukch.dongiveupbe.domain.quiz_comment.entity.QuizComment;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuizCommentRequestDto {
    @Hidden
    private Long quizId;
    @Hidden
    private Long memberId;

    private String quizCommentContent;
    @Hidden
    private LocalDateTime quizCommentCreatedAt;

    @Builder
    public static QuizComment toEntity(QuizCommentRequestDto quizCommentRequestDto) {
        return QuizComment.builder()
                .quizId(quizCommentRequestDto.getQuizId())
                .memberId(quizCommentRequestDto.getMemberId())
                .quizCommentContent(quizCommentRequestDto.getQuizCommentContent())
                .quizCommentCreatedAt(quizCommentRequestDto.getQuizCommentCreatedAt())
                .build();
    }
}
