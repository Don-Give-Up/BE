package com.virtukch.dongiveupbe.domain.quiz_solve_record.dataloader;

import com.virtukch.dongiveupbe.domain.quiz_solve_record.entity.Correct;
import com.virtukch.dongiveupbe.domain.quiz_solve_record.entity.QuizSolveRecord;
import com.virtukch.dongiveupbe.domain.quiz_solve_record.repository.QuizSolveRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Profile({"localCreate", "devCreate", "prodCreate"})
public class QuizSolveRecordDataLoader implements CommandLineRunner {

    private final QuizSolveRecordRepository quizSolveRecordRepository;

    @Autowired
    public QuizSolveRecordDataLoader(QuizSolveRecordRepository quizSolveRecordRepository) {
        this.quizSolveRecordRepository = quizSolveRecordRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // memberId가 1L인 데이터 추가
        addQuizSolveRecords(1L, 1L);

        // memberId가 2L인 데이터 추가
        addQuizSolveRecords(2L, 1L);
    }

    private void addQuizSolveRecords(Long gameMemberId, Long gameId) {
        quizSolveRecordRepository.save(QuizSolveRecord.builder()
                .gameMemberId(gameMemberId)
                .gameId(gameId)
                .quizId(146L)
                .createdAt(LocalDateTime.now())
                .correct(Correct.CORRECT)
                .quizCorrectMoney(8590)
                .build());

        quizSolveRecordRepository.save(QuizSolveRecord.builder()
                .gameMemberId(gameMemberId)
                .gameId(gameId)
                .quizId(147L)
                .createdAt(LocalDateTime.now())
                .correct(Correct.INCORRECT)
                .quizCorrectMoney(0)
                .build());

        quizSolveRecordRepository.save(QuizSolveRecord.builder()
                .gameMemberId(gameMemberId)
                .gameId(gameId)
                .quizId(148L)
                .createdAt(LocalDateTime.now())
                .correct(Correct.CORRECT)
                .quizCorrectMoney(8590)
                .build());

        quizSolveRecordRepository.save(QuizSolveRecord.builder()
                .gameMemberId(gameMemberId)
                .gameId(gameId)
                .quizId(149L)
                .createdAt(LocalDateTime.now())
                .correct(Correct.INCORRECT)
                .quizCorrectMoney(0)
                .build());

        quizSolveRecordRepository.save(QuizSolveRecord.builder()
                .gameMemberId(gameMemberId)
                .gameId(gameId)
                .quizId(150L)
                .createdAt(LocalDateTime.now())
                .correct(Correct.CORRECT)
                .quizCorrectMoney(8590)
                .build());
    }
}
