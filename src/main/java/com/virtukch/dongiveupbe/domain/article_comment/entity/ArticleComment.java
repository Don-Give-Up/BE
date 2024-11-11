package com.virtukch.dongiveupbe.domain.article_comment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleCommentId;

    private Long articleId;

    private Long memberId;

    @Setter
    private String articleCommentContent;

    private LocalDateTime articleCommentCreatedAt;

    @Setter
    private LocalDateTime articleCommentUpdatedAt;
}