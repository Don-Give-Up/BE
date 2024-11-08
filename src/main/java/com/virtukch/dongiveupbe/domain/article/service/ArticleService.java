package com.virtukch.dongiveupbe.domain.article.service;

import com.virtukch.dongiveupbe.domain.article.dto.ArticleRequestDto;
import com.virtukch.dongiveupbe.domain.article.dto.ArticleResponseDto;
import com.virtukch.dongiveupbe.domain.article.entity.Article;
import com.virtukch.dongiveupbe.domain.article.exception.ArticleNotFoundException;
import com.virtukch.dongiveupbe.domain.article.repository.ArticleRepository;
import com.virtukch.dongiveupbe.security.member.service.MemberService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final MemberService memberService;

    public ArticleService(ArticleRepository articleRepository, MemberService memberService) {
        this.articleRepository = articleRepository;
        this.memberService = memberService;
    }

    // 1. 글 전체 조회
    public List<ArticleResponseDto> findAll() {
        return articleRepository.findAll().stream()
            .map(article -> ArticleResponseDto.fromEntity(article,
                memberService.findMemberNicknameByMemberId(article.getMemberId()))).toList();
    }

    // 2. 글 아이디로 단일 조회
    public ArticleResponseDto findById(Long articleId) {
        Article article = articleRepository.findById(articleId)
            .orElseThrow(() -> new ArticleNotFoundException("Article not found"));
        return ArticleResponseDto.fromEntity(article,
            memberService.findMemberNicknameByMemberId(article.getMemberId()));
    }

    // 3. 글 제목으로 리스트 조회
    public List<ArticleResponseDto> findByArticleTitle(String articleTitle) {
        return articleRepository.findByArticleTitle(articleTitle).stream().map(
            article -> ArticleResponseDto.fromEntity(article,
                memberService.findMemberNicknameByMemberId(article.getMemberId()))).toList();
    }

    // 4. 작성자 이름으로 리스트 조회
    public List<ArticleResponseDto> findByMemberId(Long memberId) {
        return articleRepository.findByMemberId(memberId).stream().map(
            article -> ArticleResponseDto.fromEntity(article,
                memberService.findMemberNicknameByMemberId(article.getMemberId()))).toList();
    }

    // 5. 글 단일 작성
    public ArticleResponseDto save(ArticleRequestDto articleRequestDto, Long memberId) {
        articleRequestDto.setMemberId(memberId);
        return ArticleResponseDto.fromEntity(
            articleRepository.save(ArticleRequestDto.toEntity(articleRequestDto)),
            memberService.findMemberNicknameByMemberId(memberId));
    }
}