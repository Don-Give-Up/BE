package com.virtukch.dongiveupbe.domain.teacher_quiz.controller;

import com.virtukch.dongiveupbe.domain.quiz.dto.QuizResponseDto;
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
    @GetMapping("/member/{memberId}/game/{gameId}")
    public ResponseEntity<List<TeacherQuizResponseDto>> getQuizzesByMemberIdAndGameId(
            @PathVariable("memberId") Long memberId,
            @PathVariable("gameId") Long gameId) {
        List<TeacherQuizResponseDto> quizzes = teacherQuizService.findAll(memberId, gameId);
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

    /**
     * XR 통신 위한 메서드
     *
     * @param gameId
     * @return
     */
    @GetMapping("/game/{gameId}")
    public ResponseEntity<List<QuizResponseDto>> getQuizzesByGameId(@PathVariable("gameId") Long gameId) {
        return ResponseEntity.ok(teacherQuizService.findByGameId(gameId));
    }

    /**
     * Web 내 BE 사용 위한 메서드
     *
     * @param gameId
     * @return
     */
    @GetMapping("/be/game/{gameId}")
    public ResponseEntity<List<TeacherQuizResponseDto>> getQuizzesByGameIdForBE(@PathVariable("gameId") Long gameId) {
        List<TeacherQuizResponseDto> quizzes = teacherQuizService.findByGameIdForBE(gameId);
        return ResponseEntity.ok(quizzes);
    }
}
