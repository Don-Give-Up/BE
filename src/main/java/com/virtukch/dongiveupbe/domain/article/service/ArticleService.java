package com.virtukch.dongiveupbe.domain.article.service;

import com.virtukch.dongiveupbe.domain.article.dto.ArticleRequestDto;
import com.virtukch.dongiveupbe.domain.article.dto.ArticleResponseDto;
import com.virtukch.dongiveupbe.domain.article.entity.Article;
import com.virtukch.dongiveupbe.domain.article.exception.ArticleNotFoundException;
import com.virtukch.dongiveupbe.domain.article.repository.ArticleRepository;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    // 1. 글 전체 조회
    public List<ArticleResponseDto> findAll() {
        return articleRepository.findAll().stream().map(ArticleResponseDto::fromEntity).toList();
    }

    // 2. 글 아이디로 단일 조회
    public ArticleResponseDto findById(Long articleId) {
        return ArticleResponseDto.fromEntity(
            articleRepository.findById(articleId)
                .orElseThrow(() -> new ArticleNotFoundException("해당 아이디와 일치하는 글을 찾을 수 없습니다.")));
    }

    // 3. 글 제목으로 리스트 조회
    public List<ArticleResponseDto> findByArticleTitle(String articleTitle) {
        return articleRepository.findByArticleTitle(articleTitle).stream()
            .map(ArticleResponseDto::fromEntity).toList();
    }

    // 4. 작성자 이름으로 리스트 조회
    public List<ArticleResponseDto> findByMemberId(Long memberId) {
        return articleRepository.findByMemberId(memberId).stream()
            .map(ArticleResponseDto::fromEntity).toList();
    }

    // 5. 글 단일 작성
    public ArticleResponseDto save(ArticleRequestDto articleRequestDto) {
        return ArticleResponseDto.fromEntity(
            articleRepository.save(ArticleRequestDto.toEntity(articleRequestDto)));
    }
}