package com.virtukch.dongiveupbe.domain.comment.entity;

import com.virtukch.dongiveupbe.domain.comment.dto.QuizCommentRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class QuizComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quizCommentId;

    private Long quizId;

    private Long memberId;

    @Column(columnDefinition = "TEXT")
    private String quizCommentContent;

    private LocalDateTime quizCommentCreatedAt;

    public QuizComment(Long quizId, Long memberId, String quizCommentContent, LocalDateTime quizCommentCreatedAt) {
        this.quizId = quizId;
        this.memberId = memberId;
        this.quizCommentContent = quizCommentContent;
        this.quizCommentCreatedAt = quizCommentCreatedAt;
    }

    public void update(QuizCommentRequestDto requestDto) {
        this.quizCommentContent = requestDto.getQuizCommentContent();
        this.quizCommentCreatedAt = LocalDateTime.now();
    }
}
