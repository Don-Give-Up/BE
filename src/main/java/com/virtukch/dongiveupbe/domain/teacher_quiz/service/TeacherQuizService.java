package com.virtukch.dongiveupbe.domain.teacher_quiz.service;

import com.virtukch.dongiveupbe.domain.game.entity.Game;
import com.virtukch.dongiveupbe.domain.game.service.GameService;
import com.virtukch.dongiveupbe.domain.quiz.dto.QuizResponseDto;
import com.virtukch.dongiveupbe.domain.quiz.entity.Quiz;
import com.virtukch.dongiveupbe.domain.quiz.repository.QuizRepository;
import com.virtukch.dongiveupbe.domain.quiz.service.QuizService;
import com.virtukch.dongiveupbe.domain.teacher_quiz.dto.TeacherQuizRequestDto;
import com.virtukch.dongiveupbe.domain.teacher_quiz.dto.TeacherQuizResponseDto;
import com.virtukch.dongiveupbe.domain.teacher_quiz.entity.TeacherQuiz;
import com.virtukch.dongiveupbe.domain.teacher_quiz.exception.ForBiddenException;
import com.virtukch.dongiveupbe.domain.teacher_quiz.exception.GameNotFoundException;
import com.virtukch.dongiveupbe.domain.teacher_quiz.exception.QuizNotFoundException;
import com.virtukch.dongiveupbe.domain.teacher_quiz.repository.TeacherQuizRepository;
import com.virtukch.dongiveupbe.security.member.service.MemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherQuizService {
    private final TeacherQuizRepository teacherQuizRepository;
    private final GameService gameService;
    private final QuizRepository quizRepository;

    public TeacherQuizService(TeacherQuizRepository teacherQuizRepository, GameService gameService, QuizRepository quizRepository) {
        this.teacherQuizRepository = teacherQuizRepository;
        this.gameService = gameService;
        this.quizRepository = quizRepository;
    }

    // 1. 특정 선생님 id로 가지고 있는 퀴즈 전체 조회
    public List<TeacherQuizResponseDto> findAll(Long memberId, Long gameId) {
        List<Long> addedQuizIds = teacherQuizRepository.findByGameId(gameId)
                .stream()
                .map(TeacherQuiz::getQuizId)
                .toList();

        return teacherQuizRepository.findByMemberId(memberId)
                .stream()
                .filter(teacherQuiz -> !addedQuizIds.contains(teacherQuiz.getQuizId()))
                .map(TeacherQuizResponseDto::fromEntity)
                .toList();
    }

    // 2. 퀴즈 추가
    @Transactional
    public TeacherQuizResponseDto save(Long memberId, TeacherQuizRequestDto requestDto) {

        if (requestDto.getGameId() == null) {
            throw new GameNotFoundException("gameId는 null일 수 없습니다.");
        }

        teacherQuizRepository.findByQuizIdAndGameId(memberId, requestDto.getQuizId()).ifPresent(existingQuiz -> {
            throw new ForBiddenException("해당 퀴즈는 이미 추가되어 있습니다.");
        });
        Game game = gameService.findById(requestDto.getGameId());

        TeacherQuiz teacherQuiz = TeacherQuiz.builder()
                .memberId(memberId)
                .quizId(requestDto.getQuizId())
                .gameId(game.getGameId())
                .isStopped(requestDto.getIsStopped())
                .build();
        TeacherQuiz saved = teacherQuizRepository.save(teacherQuiz);
        return TeacherQuizResponseDto.fromEntity(saved);
    }

    // 3. 퀴즈 삭제
    @Transactional
    public void delete(Long teacherQuizId) {
        // teacherQuizId로 TeacherQuiz 엔티티 조회
        TeacherQuiz teacherQuiz = teacherQuizRepository.findById(teacherQuizId)
                .orElseThrow(() -> new QuizNotFoundException("해당 teacherQuizId로 퀴즈를 찾을 수 없습니다: " + teacherQuizId));

        // 조회된 엔티티 삭제
        teacherQuizRepository.delete(teacherQuiz);
    }

    public List<QuizResponseDto> findByGameId(Long gameId) {
        List<QuizResponseDto> quizResponseDtoList = new ArrayList<>();

        List<Quiz> quizList = teacherQuizRepository.findByGameId(gameId)
                .stream()
                .map(teacherQuiz -> quizRepository.findById(teacherQuiz.getQuizId()).orElse(null)).toList();

        for (Quiz quiz : quizList) {
            quizResponseDtoList.add(QuizResponseDto.fromEntity(quiz));
        }

        return quizResponseDtoList;
    }

    public List<TeacherQuizResponseDto> findByGameIdForBE(Long gameId) {
        return teacherQuizRepository.findByGameId(gameId)
                .stream()
                .map(TeacherQuizResponseDto::fromEntity)
                .toList();
    }
}
