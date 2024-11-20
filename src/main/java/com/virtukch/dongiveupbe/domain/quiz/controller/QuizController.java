package com.virtukch.dongiveupbe.domain.quiz.controller;

import com.virtukch.dongiveupbe.domain.quiz.dto.QuizBEResponseDto;
import com.virtukch.dongiveupbe.domain.quiz.dto.QuizRequestDto;
import com.virtukch.dongiveupbe.domain.quiz.dto.QuizResponseDto;
import com.virtukch.dongiveupbe.domain.quiz.service.QuizService;
import com.virtukch.dongiveupbe.security.common.utils.TokenUtils;
import io.jsonwebtoken.Claims;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    @GetMapping("/all")
    public ResponseEntity<Page<QuizBEResponseDto>> findAllQuiz(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String searchType,
            @RequestParam(required = false) String searchKeyword) {

        Sort sort = Sort.by(Sort.Direction.DESC, "quizId");
        PageRequest pageRequest = PageRequest.of(page, size, sort);

        // searchType과 searchKeyword를 서비스로 전달
        return ResponseEntity.ok(quizService.findAllQuiz(pageRequest, searchType, searchKeyword));
    }
    @Hidden
    @GetMapping("quiz/{quizId}")
    public ResponseEntity<QuizBEResponseDto> findByQuizId(@PathVariable Long quizId) {  // QuizResponseDto -> QuizBEResponseDto로 변경
        return ResponseEntity.ok(quizService.findByQuizId(quizId));  // 작성자 닉네임을 포함하여 반환
    }

    // 2. 퀴즈 아이디로 조회
    @GetMapping("{quizId}")
    public ResponseEntity<QuizResponseDto> findById(@PathVariable Long quizId) {
        return ResponseEntity.ok(quizService.findById(quizId));
    }

    // 3. 퀴즈 단일 생성
    @PostMapping
    public ResponseEntity<QuizResponseDto> create(@RequestBody QuizRequestDto quizRequestDto,
        HttpServletRequest request) {
        Claims claims = TokenUtils.getClaimsFromRequest(request);
        Long memberId = claims.get("memberId", Long.class); // 사용자 ID 추출
        QuizResponseDto createdQuiz = quizService.save(quizRequestDto, memberId);
        return ResponseEntity.ok(createdQuiz);
    }
}