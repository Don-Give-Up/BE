package com.virtukch.dongiveupbe.domain.article_comment.dto;

import com.virtukch.dongiveupbe.domain.article_comment.entity.ArticleComment;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleCommentRequestDto {

    private Long articleId;

    @Setter
    private Long memberId;

    private String articleCommentContent;

    private LocalDateTime articleCommentCreatedAt;

    public static ArticleComment toEntity(ArticleCommentRequestDto articleCommentRequestDto) {
        return ArticleComment.builder()
            .articleId(articleCommentRequestDto.articleId)
            .memberId(articleCommentRequestDto.memberId)
            .articleCommentContent(articleCommentRequestDto.articleCommentContent)
            .articleCommentCreatedAt(articleCommentRequestDto.articleCommentCreatedAt)
            .build();
    }
}