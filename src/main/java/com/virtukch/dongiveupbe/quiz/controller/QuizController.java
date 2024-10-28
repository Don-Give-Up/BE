package com.virtukch.dongiveupbe.quiz.controller;

import com.virtukch.dongiveupbe.quiz.dto.QuizRequestDto;
import com.virtukch.dongiveupbe.quiz.dto.QuizResponseDto;
import com.virtukch.dongiveupbe.quiz.service.QuizService;
import io.swagger.v3.oas.annotations.Operation;
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

    @GetMapping
    @Operation(summary = "모든 퀴즈를 조회하고 싶을 때 호출해 주시면 됩니다.")
    public ResponseEntity<List<QuizResponseDto>> findAll() {
        return quizService.findAll();
    }

    @GetMapping("{quizId}")
    @Operation(summary = "특정 퀴즈를 조회하고 싶을 때 호출해 주시면 됩니다. 퀴즈 아이디를 path 에 담아야 합니다.", description = "퀴즈 아이디는 api/v1/quizs 에서 조회할 수 있습니다.")
    public ResponseEntity<QuizResponseDto> findById(@PathVariable Long quizId) {
        return quizService.findById(quizId);
    }

    @PostMapping
    @Operation(summary = "퀴즈를 생성하고 싶을 때 호출해 주시면 됩니다.")
    public ResponseEntity<QuizResponseDto> save(@RequestBody QuizRequestDto quizRequestDto) {
        return ResponseEntity.ok(quizService.save(quizRequestDto));
    }
}