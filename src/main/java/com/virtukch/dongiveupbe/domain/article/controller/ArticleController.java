package com.virtukch.dongiveupbe.domain.article.controller;

import com.virtukch.dongiveupbe.domain.article.dto.ArticleRequestDto;
import com.virtukch.dongiveupbe.domain.article.dto.ArticleResponseDto;
import com.virtukch.dongiveupbe.domain.article.service.ArticleService;
import com.virtukch.dongiveupbe.security.common.utils.TokenUtils;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    // 1. 글 전체 조회
    @GetMapping
    public ResponseEntity<List<ArticleResponseDto>> findAll() {
        return ResponseEntity.ok(articleService.findAll());
    }

    // 2. 글 아이디로 단일 조회
    @GetMapping("/{articleId}")
    public ResponseEntity<ArticleResponseDto> findById(@PathVariable Long articleId) {
        return ResponseEntity.ok(articleService.findById(articleId));
    }

    // 3. 글 단일 작성
    @PostMapping
    public ResponseEntity<ArticleResponseDto> save(@RequestBody ArticleRequestDto articleRequestDto,
        HttpServletRequest request) {
        Long memberId = TokenUtils.getClaimsFromRequest(request).get("memberId", Long.class);
        return ResponseEntity.ok(articleService.save(articleRequestDto, memberId));
    }
}