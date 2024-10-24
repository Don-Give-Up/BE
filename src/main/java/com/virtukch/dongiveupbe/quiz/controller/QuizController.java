package com.virtukch.dongiveupbe.quiz.controller;

import com.virtukch.dongiveupbe.quiz.dto.QuizResponseDto;
import com.virtukch.dongiveupbe.quiz.service.QuizService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/quizs")
public class QuizController {
    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping
    public ResponseEntity<List<QuizResponseDto>> findAll() {
        return ResponseEntity.ok(quizService.findAll());
    }
}