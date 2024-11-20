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

    // localCreate, devCreate, prodCreate 프로파일에서만 실행
    @Override
    public void run(String... args) throws Exception {
        QuizSolveRecord record1 = QuizSolveRecord.builder()
                .gameMemberId(1L)
                .quizId(146L)
                .createdAt(LocalDateTime.now())
                .correct(Correct.CORRECT)
                .quizCorrectMoney(8590)
                .build();
        quizSolveRecordRepository.save(record1);

        QuizSolveRecord record2 = QuizSolveRecord.builder()
                .gameMemberId(2L)
                .quizId(147L)
                .createdAt(LocalDateTime.now())
                .correct(Correct.INCORRECT)
                .quizCorrectMoney(0)
                .build();
        quizSolveRecordRepository.save(record2);

        QuizSolveRecord record3 = QuizSolveRecord.builder()
                .gameMemberId(1L)
                .quizId(148L)
                .createdAt(LocalDateTime.now())
                .correct(Correct.CORRECT)
                .quizCorrectMoney(8590)
                .build();
        quizSolveRecordRepository.save(record3);
        QuizSolveRecord record4 = QuizSolveRecord.builder()
                .gameMemberId(1L)
                .quizId(149L)
                .createdAt(LocalDateTime.now())
                .correct(Correct.INCORRECT)
                .quizCorrectMoney(0)
                .build();
        quizSolveRecordRepository.save(record4);
        QuizSolveRecord record5 = QuizSolveRecord.builder()
                .gameMemberId(1L)
                .quizId(150L)
                .createdAt(LocalDateTime.now())
                .correct(Correct.CORRECT)
                .quizCorrectMoney(8590)
                .build();
        quizSolveRecordRepository.save(record5);
    }
}
