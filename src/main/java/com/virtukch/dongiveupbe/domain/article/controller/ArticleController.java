package com.virtukch.dongiveupbe.domain.article.controller;

import com.virtukch.dongiveupbe.domain.article.dto.ArticleRequestDto;
import com.virtukch.dongiveupbe.domain.article.dto.ArticleResponseDto;
import com.virtukch.dongiveupbe.domain.article.entity.Article;
import com.virtukch.dongiveupbe.domain.article.service.ArticleService;
import com.virtukch.dongiveupbe.domain.quiz.dto.QuizResponseDto;
import com.virtukch.dongiveupbe.security.common.utils.TokenUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
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

    // 3. 글 제목으로 리스트 조회
    @GetMapping("/{articleTitle}")
    public ResponseEntity<List<ArticleResponseDto>> findByArticleTitle(@PathVariable String articleTitle) {
        return ResponseEntity.ok(articleService.findByArticleTitle(articleTitle));
    }

    // 4. 작성자 이름으로 리스트 조회
    @GetMapping("/{memberId}")
    public ResponseEntity<List<ArticleResponseDto>> findByMemberId(@PathVariable Long memberId) {
        return ResponseEntity.ok(articleService.findByMemberId(memberId));
    }

    // 5. 글 단일 작성
    @PostMapping
    public ResponseEntity<ArticleResponseDto> save(@RequestBody ArticleRequestDto articleRequestDto,
        HttpServletRequest request) {
        String token = TokenUtils.splitHeader(request.getHeader("Authorization"));
        if (token != null && TokenUtils.isValidToken(token)) {
            Claims claims = TokenUtils.getClaimsFromToken(token); // 토큰에서 사용자 정보 추출
            Long memberId = claims.get("memberId", Long.class); // 사용자 ID 추출
            return ResponseEntity.ok(articleService.save(articleRequestDto, memberId));
        } else {
            return ResponseEntity.status(401).build(); // 인증 실패 시 401 Unauthorized 반환
        }
    }
}