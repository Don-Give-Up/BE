package com.virtukch.dongiveupbe.domain.quiz_solve_record.service;

import com.virtukch.dongiveupbe.domain.essential_product.exception.EntityNotFoundException;
import com.virtukch.dongiveupbe.domain.game_member.dto.GameMemberRequestDto;
import com.virtukch.dongiveupbe.domain.game_member.dto.GameMemberResponseDto;
import com.virtukch.dongiveupbe.domain.game_member.service.GameMemberService;
import com.virtukch.dongiveupbe.domain.quiz_solve_record.dto.QuizSolveRecordRequestDto;
import com.virtukch.dongiveupbe.domain.quiz_solve_record.dto.QuizSolveRecordResponseDto;
import com.virtukch.dongiveupbe.domain.quiz_solve_record.entity.Correct;
import com.virtukch.dongiveupbe.domain.quiz_solve_record.entity.QuizSolveRecord;
import com.virtukch.dongiveupbe.domain.quiz_solve_record.exception.DuplicateQuizSolveException;
import com.virtukch.dongiveupbe.domain.quiz_solve_record.repository.QuizSolveRecordRepository;
import com.virtukch.dongiveupbe.domain.round.entity.Round;
import com.virtukch.dongiveupbe.domain.round.service.RoundService;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuizSolveRecordService {

    private final QuizSolveRecordRepository quizSolveRecordRepository;
    private final GameMemberService gameMemberService;

    private static final int SALARY_PER_QUIZ = 8590;

    @Autowired
    public QuizSolveRecordService(QuizSolveRecordRepository quizSolveRecordRepository, GameMemberService gameMemberService) {
        this.quizSolveRecordRepository = quizSolveRecordRepository;
        this.gameMemberService = gameMemberService;
    }

    public ResponseEntity<QuizSolveRecordResponseDto> save(
        QuizSolveRecordRequestDto quizSolveRecordRequestDto) {
        QuizSolveRecord quizSolveRecord = quizSolveRecordRequestDto.toEntity(
            quizSolveRecordRequestDto);
        QuizSolveRecord saveddQuizSolveRecord = quizSolveRecordRepository.save(quizSolveRecord);
        return ResponseEntity.ok(QuizSolveRecordResponseDto.fromEntity(saveddQuizSolveRecord));
    }

    public ResponseEntity<List<QuizSolveRecordResponseDto>> findAll() {
        return ResponseEntity.ok(quizSolveRecordRepository.findAll().stream()
            .map(QuizSolveRecordResponseDto::fromEntity)
            .toList());
    }

    public ResponseEntity<List<QuizSolveRecordResponseDto>> findByGameMemberId(Long gameMemberId) {
        return ResponseEntity.ok(quizSolveRecordRepository.findByGameMemberId(gameMemberId).stream()
            .map(QuizSolveRecordResponseDto::fromEntity).toList());
    }

    public QuizSolveRecordResponseDto saveQuizSolveRecord(QuizSolveRecordRequestDto requestDto) {
        // 게임 멤버 검증 및 정보 가져오기
        GameMemberResponseDto gameMemberResponse = gameMemberService.findById(requestDto.getGameMemberId());
        if (gameMemberResponse == null) {
            throw new EntityNotFoundException("게임 멤버를 찾을 수 없습니다. ID: " + requestDto.getGameMemberId());
        }

        // 중복 퀴즈 풀이 확인
        boolean hasSolvedQuiz = quizSolveRecordRepository.existsByGameMemberIdAndQuizId(
                requestDto.getGameMemberId(), requestDto.getQuizId()
        );
        if (hasSolvedQuiz) {
            throw new DuplicateQuizSolveException("이미 푼 퀴즈입니다. quizId: " + requestDto.getQuizId());
        }

        // 현재 돈 계산
        int currentMoney = gameMemberResponse.getGameMemberMoney() != null ? gameMemberResponse.getGameMemberMoney() : 0;

        // 퀴즈 풀이 기록 생성 및 저장
        QuizSolveRecord quizSolveRecord = QuizSolveRecord.builder()
                .gameMemberId(requestDto.getGameMemberId())
                .quizId(requestDto.getQuizId())
                .createdAt(requestDto.getCreatedAt() != null ? requestDto.getCreatedAt() : LocalDateTime.now())
                .correct(requestDto.getCorrect())
                .quizCorrectMoney(requestDto.getCorrect() == Correct.CORRECT ? SALARY_PER_QUIZ : 0)
                .build();
        quizSolveRecord = quizSolveRecordRepository.save(quizSolveRecord);

        // 정답일 경우 돈 추가
        if (requestDto.getCorrect() == Correct.CORRECT) {
            int updatedMoney = currentMoney + SALARY_PER_QUIZ;

            GameMemberRequestDto updatedGameMember = GameMemberRequestDto.builder()
                    .gameMemberId(gameMemberResponse.getGameMemberId())
                    .memberId(gameMemberResponse.getMemberId())
                    .gameId(gameMemberResponse.getGameId())
                    .gameMemberMoney(updatedMoney)
                    .build();

            // 게임 멤버 돈 업데이트
            gameMemberService.save(updatedGameMember);
        }

        return QuizSolveRecordResponseDto.fromEntity(quizSolveRecord);
    }
}