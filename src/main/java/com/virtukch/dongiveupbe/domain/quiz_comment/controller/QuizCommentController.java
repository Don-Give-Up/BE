package com.virtukch.dongiveupbe.domain.quiz_comment.controller;

import com.virtukch.dongiveupbe.domain.quiz_comment.dto.QuizCommentRequestDto;
import com.virtukch.dongiveupbe.domain.quiz_comment.dto.QuizCommentResponseDto;
import com.virtukch.dongiveupbe.domain.quiz_comment.service.QuizCommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
public class QuizCommentController {
    private final QuizCommentService quizCommentService;

    public QuizCommentController(QuizCommentService quizCommentService) {
        this.quizCommentService = quizCommentService;
    }

    // 특정 퀴즈의 모든 댓글 조회
    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<List<QuizCommentResponseDto>> getAllCommentsByQuizId(@PathVariable Long quizId) {
        List<QuizCommentResponseDto> comments = quizCommentService.getAllCommentsByQuizId(quizId);
        return ResponseEntity.ok(comments);
    }

    // 특정 댓글 조회
    @GetMapping("/{commentId}")
    public ResponseEntity<QuizCommentResponseDto> getCommentById(@PathVariable Long commentId) {
        QuizCommentResponseDto comment = quizCommentService.getCommentById(commentId);
        return ResponseEntity.ok(comment);
    }

    // 댓글 생성
    @PostMapping("/quiz/{quizId}")
    public ResponseEntity<QuizCommentResponseDto> save(@RequestBody QuizCommentRequestDto requestDto,
                                                       @PathVariable Long quizId) {
        QuizCommentResponseDto responseDto = quizCommentService.save(quizId, requestDto);
        return ResponseEntity.ok(responseDto);
    }

    // 댓글 수정
    @PutMapping("/{commentId}")
    public ResponseEntity<QuizCommentResponseDto> update(@PathVariable Long commentId,
                                                         @RequestBody QuizCommentRequestDto requestDto) {
        QuizCommentResponseDto responseDto = quizCommentService.update(commentId, requestDto);
        return ResponseEntity.ok(responseDto);
    }

    // 댓글 삭제
    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> delete(@PathVariable Long commentId) {
        quizCommentService.delete(commentId);
        return ResponseEntity.noContent().build();
    }
}
