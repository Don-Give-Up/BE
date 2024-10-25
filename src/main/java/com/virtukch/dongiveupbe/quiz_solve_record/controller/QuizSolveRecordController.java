package com.virtukch.dongiveupbe.quiz_solve_record.controller;

import com.virtukch.dongiveupbe.quiz_solve_record.dto.QuizSolveRecordRegisterRequestDto;
import com.virtukch.dongiveupbe.quiz_solve_record.dto.QuizSolveRecordResponseDto;
import com.virtukch.dongiveupbe.quiz_solve_record.service.QuizSolveRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/quiz-solve-record")
public class QuizSolveRecordController {

    private final QuizSolveRecordService quizSolveRecordService;

    @Autowired
    public QuizSolveRecordController(QuizSolveRecordService quizSolveRecordService) {
        this.quizSolveRecordService = quizSolveRecordService;
    }

    // 퀴즈 푸는 기록 생성
    @PostMapping
    public ResponseEntity<QuizSolveRecordResponseDto> save(
        @RequestBody QuizSolveRecordRegisterRequestDto quizSolveRecordRegisterRequestDto) {
        return quizSolveRecordService.save(quizSolveRecordRegisterRequestDto);
    }
}