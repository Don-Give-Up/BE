package com.virtukch.dongiveupbe.domain.quiz.controller;

import com.virtukch.dongiveupbe.domain.quiz.service.QuizService;
import com.virtukch.dongiveupbe.domain.quiz.dto.QuizRequestDto;
import com.virtukch.dongiveupbe.domain.quiz.dto.QuizResponseDto;
import com.virtukch.dongiveupbe.security.common.utils.TokenUtils;
import io.jsonwebtoken.Claims;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.Collections;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1/quizs")
@Tag(name = "퀴즈 API", description = "퀴즈를 조회하고 관리하기 위한 API")
public class QuizController {

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    // 1. 퀴즈 전체 조회
    @GetMapping
    public ResponseEntity<List<QuizResponseDto>> findAll() {
        return ResponseEntity.ok(quizService.findAll());
    }

    // 2. 퀴즈 아이디로 조회
    @GetMapping("{quizId}")
    public ResponseEntity<QuizResponseDto> findById(@PathVariable Long quizId) {
        return ResponseEntity.ok(quizService.findById(quizId));
    }

    // 3. 퀴즈 단일 생성
    @PostMapping
    public ResponseEntity<QuizResponseDto> create(
            @RequestBody QuizRequestDto quizRequestDto,
            HttpServletRequest request
    ) {
        // Authorization 헤더에서 JWT 토큰 추출 및 검증
        String token = TokenUtils.splitHeader(request.getHeader("Authorization"));
        if (token != null && TokenUtils.isValidToken(token)) {
            Claims claims = TokenUtils.getClaimsFromToken(token); // 토큰에서 사용자 정보 추출
            Long memberId = claims.get("memberId", Long.class); // 사용자 ID 추출

            // 사용자 정보와 함께 퀴즈 생성
            QuizResponseDto createdQuiz = quizService.save(quizRequestDto, memberId);
            return ResponseEntity.ok(createdQuiz);
        } else {
            return ResponseEntity.status(401).build(); // 인증 실패 시 401 Unauthorized 반환
        }
    }
}