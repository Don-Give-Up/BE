package com.virtukch.dongiveupbe.quiz.controller;

import com.virtukch.dongiveupbe.quiz.dto.QuizResponseDto;
import com.virtukch.dongiveupbe.quiz.service.QuizService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Hidden
@RestController
@RequestMapping("api/v1/quizs")
@Tag(name = "퀴즈 API", description = "퀴즈를 조회하고 관리하기 위한 API")
public class QuizController {

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping
    @Operation(summary = "모든 퀴즈 조회")
    public ResponseEntity<List<QuizResponseDto>> findAll() {
        return quizService.findAll();
    }

    @GetMapping("{quizId}")
    @Operation(summary = "퀴즈 아이디로 퀴즈 조회")
    public ResponseEntity<QuizResponseDto> findById(@PathVariable Long quizId) {
        return quizService.findById(quizId);
    }
}