package com.virtukch.dongiveupbe.domain.article.dto;

import com.virtukch.dongiveupbe.domain.article.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleRequestDto {

    @Setter
    private Long memberId;

    private String articleTitle;

    private String articleContents;

    public static Article toEntity(ArticleRequestDto articleRequestDto) {
        return Article.builder()
            .memberId(articleRequestDto.getMemberId())
            .articleTitle(articleRequestDto.getArticleTitle())
            .articleContents(articleRequestDto.getArticleContents())
            .build();
    }
}