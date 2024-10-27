package com.virtukch.dongiveupbe.quiz_solve_record.service;

import com.virtukch.dongiveupbe.essential_product.exception.EntityNotFoundException;
import com.virtukch.dongiveupbe.game_member.dto.GameMemberRequestDto;
import com.virtukch.dongiveupbe.game_member.dto.GameMemberResponseDto;
import com.virtukch.dongiveupbe.game_member.entity.GameMember;
import com.virtukch.dongiveupbe.game_member.service.GameMemberService;
import com.virtukch.dongiveupbe.quiz_solve_record.dto.QuizSolveRecordRequestDto;
import com.virtukch.dongiveupbe.quiz_solve_record.dto.QuizSolveRecordResponseDto;
import com.virtukch.dongiveupbe.quiz_solve_record.entity.QuizSolveRecord;
import com.virtukch.dongiveupbe.quiz_solve_record.repository.QuizSolveRecordRepository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.virtukch.dongiveupbe.round.entity.Round;
import com.virtukch.dongiveupbe.round.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuizSolveRecordService {

    private final QuizSolveRecordRepository quizSolveRecordRepository;
    private final RoundService roundService;
    private final GameMemberService gameMemberService;

    @Autowired
    public QuizSolveRecordService(QuizSolveRecordRepository quizSolveRecordRepository, RoundService roundService, GameMemberService gameMemberService) {
        this.quizSolveRecordRepository = quizSolveRecordRepository;
        this.roundService = roundService;
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
        // 게임 멤버 찾기
        GameMemberResponseDto gameMemberResponse = gameMemberService.findById(requestDto.getGameMemberId());
        if (gameMemberResponse == null) {
            throw new EntityNotFoundException("게임 멤버를 찾을 수 없습니다. ID: " + requestDto.getGameMemberId());
        }

        // roundId로 해당 라운드 찾기
        Round currentRound = roundService.findRoundById(requestDto.getRoundId());

        // 라운드 급여를 25문제로 나눠서 퀴즈 하나당 지급할 금액 계산
        int salaryPerQuiz = currentRound.getRoundSalary().intValue() / 25;

        // 문제 해결 기록 생성 (salaryPerQuiz 값을 quizCorrectMoney로 설정)
        QuizSolveRecord quizSolveRecord = QuizSolveRecord.builder()
                .gameMemberId(requestDto.getGameMemberId())
                .quizId(requestDto.getQuizId())
                .roundId(requestDto.getRoundId())
                .createdAt(requestDto.getCreatedAt())
                .correct(requestDto.getCorrect())
                .attemptCount(requestDto.getAttemptCount())
                .quizCorrectMoney(salaryPerQuiz) // setter 사용 없이 빌더에서 직접 설정
                .build();
        quizSolveRecord = quizSolveRecordRepository.save(quizSolveRecord);

        // 게임 멤버의 돈 업데이트 (퀴즈 하나를 맞출 때마다 지급)
        int updatedMoney = gameMemberResponse.getGameMemberMoney() + salaryPerQuiz;
        GameMemberRequestDto gameMemberRequestDto = GameMemberRequestDto.builder()
                .gameMemberId(gameMemberResponse.getGameMemberId())
                .memberId(gameMemberResponse.getMemberId())
                .gameId(gameMemberResponse.getGameId())
                .gameMemberMoney(updatedMoney)
                .build();

        // 수정된 게임 멤버 저장
        gameMemberService.save(gameMemberRequestDto);

        return QuizSolveRecordResponseDto.fromEntity(quizSolveRecord);
    }


}