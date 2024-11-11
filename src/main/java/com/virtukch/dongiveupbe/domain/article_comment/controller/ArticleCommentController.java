package com.virtukch.dongiveupbe.domain.article_comment.controller;

import com.virtukch.dongiveupbe.domain.article_comment.dto.ArticleCommentPatchRequestDto;
import com.virtukch.dongiveupbe.domain.article_comment.dto.ArticleCommentRequestDto;
import com.virtukch.dongiveupbe.domain.article_comment.dto.ArticleCommentResponseDto;
import com.virtukch.dongiveupbe.domain.article_comment.service.ArticleCommentService;
import com.virtukch.dongiveupbe.security.common.utils.TokenUtils;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/article-comments")
public class ArticleCommentController {

    private final ArticleCommentService articleCommentService;

    @Autowired
    public ArticleCommentController(ArticleCommentService articleCommentService) {
        this.articleCommentService = articleCommentService;
    }

    // 1. 댓글 전체 조회
    @GetMapping
    public ResponseEntity<List<ArticleCommentResponseDto>> findAll(@RequestParam Long articleId) {
        return ResponseEntity.ok(articleCommentService.findAllByArticleId(articleId));
    }

    // 2. 댓글 작성
    @PostMapping
    public ResponseEntity<ArticleCommentResponseDto> save(
        @RequestBody ArticleCommentRequestDto articleCommentRequestDto, HttpServletRequest httpServletRequest) {
        Long memberId = TokenUtils.getClaimsFromRequest(httpServletRequest).get("memberId", Long.class);
        return ResponseEntity.ok(articleCommentService.save(articleCommentRequestDto, memberId));
    }

    // 3. 댓글 수정
    @PatchMapping("{articleCommentId}")
    public ResponseEntity<ArticleCommentResponseDto> update(@PathVariable Long articleCommentId,
        @RequestBody ArticleCommentPatchRequestDto articleCommentPatchRequestDto) {
        return ResponseEntity.ok(articleCommentService.save(articleCommentId, articleCommentPatchRequestDto));
    }

    // 4. 댓글 삭제
    @DeleteMapping("{articleCommentId}")
    public void delete(@PathVariable Long articleCommentId) {
        articleCommentService.deleteById(articleCommentId);
    }
}