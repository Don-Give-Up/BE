package com.virtukch.dongiveupbe.quiz_solve_record.controller;

import com.virtukch.dongiveupbe.quiz_solve_record.dto.QuizSolveRecordRequestDto;
import com.virtukch.dongiveupbe.quiz_solve_record.dto.QuizSolveRecordResponseDto;
import com.virtukch.dongiveupbe.quiz_solve_record.service.QuizSolveRecordService;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/quiz-solve-records")
@Tag(name = "퀴즈 풀이 기록 API", description = "사용자의 퀴즈 풀이 기록을 관리하기 위한 API")
public class QuizSolveRecordController {

    private final QuizSolveRecordService quizSolveRecordService;

    @Autowired
    public QuizSolveRecordController(QuizSolveRecordService quizSolveRecordService) {
        this.quizSolveRecordService = quizSolveRecordService;
    }

    // 퀴즈 푸는 기록 생성
    @PostMapping
    @Operation(summary = "퀴즈 풀이 기록 생성")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "퀴즈 풀이 기록 생성 성공",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = QuizSolveRecordResponseDto.class))),
        @ApiResponse(responseCode = "400", description = "잘못된 요청 (예: 요청 데이터 형식 오류)",
            content = @Content)
    })
    public ResponseEntity<QuizSolveRecordResponseDto> save(
        @RequestBody QuizSolveRecordRequestDto quizSolveRecordRequestDto) {
        return quizSolveRecordService.save(quizSolveRecordRequestDto);
    }

    // 퀴즈 전체 기록 조회
    @GetMapping
    @Operation(summary = "퀴즈 풀이 기록 전체 조회")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "퀴즈 풀이 기록 조회 성공",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = QuizSolveRecordResponseDto.class))),
        @ApiResponse(responseCode = "404", description = "기록이 존재하지 않음",
            content = @Content)
    })
    public ResponseEntity<List<QuizSolveRecordResponseDto>> findAll() {
        return quizSolveRecordService.findAll();
    }

    // 특정 학생의 아이디를 통한 기록 조회
    @GetMapping("{gameMemberId}")
    @Operation(summary = "특정 학생의 퀴즈 풀이 기록 조회")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "특정 학생의 퀴즈 풀이 기록 조회 성공",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = QuizSolveRecordResponseDto.class))),
        @ApiResponse(responseCode = "404", description = "해당 학생의 기록이 존재하지 않음",
            content = @Content),
        @ApiResponse(responseCode = "400", description = "잘못된 요청 (예: 잘못된 gameMemberId 형식)",
            content = @Content)
    })
    public ResponseEntity<List<QuizSolveRecordResponseDto>> findByGameMemberId(@PathVariable Long gameMemberId) {
        return quizSolveRecordService.findByGameMemberId(gameMemberId);
    }
}