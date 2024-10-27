package com.virtukch.dongiveupbe.quiz.controller;

import com.virtukch.dongiveupbe.quiz.dto.QuizResponseDto;
import com.virtukch.dongiveupbe.quiz.service.QuizService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "퀴즈 목록 조회 성공",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = QuizResponseDto.class))),
        @ApiResponse(responseCode = "404", description = "퀴즈가 존재하지 않음",
            content = @Content)
    })
    public ResponseEntity<List<QuizResponseDto>> findAll() {
        return quizService.findAll();
    }

    @GetMapping("{quizId}")
    @Operation(summary = "특정 퀴즈 조회")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "퀴즈 조회 성공",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = QuizResponseDto.class))),
        @ApiResponse(responseCode = "404", description = "해당 퀴즈가 존재하지 않음",
            content = @Content),
        @ApiResponse(responseCode = "400", description = "잘못된 요청 (예: 잘못된 quizId 형식)",
            content = @Content)
    })
    public ResponseEntity<QuizResponseDto> findById(@PathVariable Long quizId) {
        return quizService.findById(quizId);
    }
}