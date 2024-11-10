package com.virtukch.dongiveupbe.domain.article_comment.dto;

import com.virtukch.dongiveupbe.domain.article_comment.entity.ArticleComment;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleCommentResponseDto {

    private Long articleCommentId;

    private Long articleId;

    private String memberNickname;

    private String articleCommentContent;

    private LocalDateTime articleCommentCreatedAt;

    public static ArticleCommentResponseDto fromEntity(ArticleComment articleComment, String memberNickname) {
        return ArticleCommentResponseDto.builder()
            .articleCommentId(articleComment.getArticleCommentId())
            .articleId(articleComment.getArticleId())
            .memberNickname(memberNickname)
            .articleCommentContent(articleComment.getArticleCommentContent())
            .articleCommentCreatedAt(articleComment.getArticleCommentCreatedAt())
            .build();
    }
}