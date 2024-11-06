package com.virtukch.dongiveupbe.domain.article.dto;

import com.virtukch.dongiveupbe.domain.article.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleResponseDto {

    private Long articleId;

    private Long memberId;

    private String articleTitle;

    private String articleContents;

    public static ArticleResponseDto fromEntity(Article article) {
        return ArticleResponseDto.builder()
            .articleId(article.getArticleId())
            .memberId(article.getMemberId())
            .articleTitle(article.getArticleTitle())
            .articleContents(article.getArticleContents())
            .build();
    }
}