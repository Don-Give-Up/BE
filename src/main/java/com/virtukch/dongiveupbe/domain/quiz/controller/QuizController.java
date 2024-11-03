package com.virtukch.dongiveupbe.domain.quiz.controller;

import com.virtukch.dongiveupbe.domain.quiz.service.QuizService;
import com.virtukch.dongiveupbe.domain.quiz.dto.QuizRequestDto;
import com.virtukch.dongiveupbe.domain.quiz.dto.QuizResponseDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<QuizResponseDto> create(@RequestBody QuizRequestDto quizRequestDto) {
        return ResponseEntity.ok(quizService.save(quizRequestDto));
    }
}