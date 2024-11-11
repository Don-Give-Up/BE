package com.virtukch.dongiveupbe.domain.quiz_comment.dto;

import com.virtukch.dongiveupbe.domain.quiz_comment.entity.QuizComment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuizCommentResponseDto {
    private Long quizCommentId;

    private Long quizId;

    private String memberNickname;

    private String quizCommentContent;

    private LocalDateTime quizCommentCreatedAt;


    public static QuizCommentResponseDto fromEntity(QuizComment quizComment, String memberNickname) {
        return QuizCommentResponseDto.builder()
                .quizCommentId(quizComment.getQuizCommentId())
                .quizId(quizComment.getQuizId())
                .memberNickname(memberNickname)
                .quizCommentContent(quizComment.getQuizCommentContent())
                .quizCommentCreatedAt(quizComment.getQuizCommentCreatedAt())
                .build();
    }
}
