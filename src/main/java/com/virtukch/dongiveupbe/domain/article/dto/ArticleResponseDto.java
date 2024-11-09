package com.virtukch.dongiveupbe.domain.article.dto;

import com.virtukch.dongiveupbe.domain.article.entity.Article;
import java.time.LocalDateTime;
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

    private String memberNickname;

    private String articleTitle;

    private String articleContents;

    private LocalDateTime createdAt;

    public static ArticleResponseDto fromEntity(Article article, String memberNickname) {
        return ArticleResponseDto.builder()
            .articleId(article.getArticleId())
            .memberNickname(memberNickname)
            .articleTitle(article.getArticleTitle())
            .articleContents(article.getArticleContents())
            .createdAt(article.getCreatedAt())
            .build();
    }
}