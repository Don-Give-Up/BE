package com.virtukch.dongiveupbe.domain.teacher_quiz.controller;

import com.virtukch.dongiveupbe.domain.teacher_quiz.dto.TeacherQuizRequestDto;
import com.virtukch.dongiveupbe.domain.teacher_quiz.dto.TeacherQuizResponseDto;
import com.virtukch.dongiveupbe.domain.teacher_quiz.service.TeacherQuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teacher-quizzes")
public class TeacherQuizController {
    private final TeacherQuizService teacherQuizService;

    public TeacherQuizController(TeacherQuizService teacherQuizService) {
        this.teacherQuizService = teacherQuizService;
    }

    // 특정 선생님의 퀴즈 조회
    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<TeacherQuizResponseDto>> getQuizzesByMemberId(@PathVariable("memberId") Long memberId) {
        List<TeacherQuizResponseDto> quizzes = teacherQuizService.findAll(memberId);
        return ResponseEntity.ok(quizzes);
    }

    // 퀴즈 추가
    @PostMapping("/member/{memberId}")
    public ResponseEntity<TeacherQuizResponseDto> save(@PathVariable("memberId") Long memberId,
                                                       @RequestBody TeacherQuizRequestDto requestDto) {
        System.out.println("Received gameId: " + requestDto.getGameId());
        TeacherQuizResponseDto responseDto = teacherQuizService.save(memberId, requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/quiz/{quizId}")
    public ResponseEntity<Void> delete(@PathVariable("quizId") Long quizId) {
        teacherQuizService.delete(quizId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/game/{gameId}")
    public ResponseEntity<List<TeacherQuizResponseDto>> getQuizzesByGameId(@PathVariable("gameId") Long gameId) {
        List<TeacherQuizResponseDto> quizzes = teacherQuizService.findByGameId(gameId);
        return ResponseEntity.ok(quizzes);
    }
}
