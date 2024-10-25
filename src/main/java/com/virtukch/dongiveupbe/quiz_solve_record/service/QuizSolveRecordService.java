package com.virtukch.dongiveupbe.quiz_solve_record.service;

import com.virtukch.dongiveupbe.quiz_solve_record.dto.QuizSolveRecordRegisterRequestDto;
import com.virtukch.dongiveupbe.quiz_solve_record.dto.QuizSolveRecordResponseDto;
import com.virtukch.dongiveupbe.quiz_solve_record.entity.QuizSolveRecord;
import com.virtukch.dongiveupbe.quiz_solve_record.repository.QuizSolveRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuizSolveRecordService {

    private final QuizSolveRecordRepository quizSolveRecordRepository;

    @Autowired
    public QuizSolveRecordService(QuizSolveRecordRepository quizSolveRecordRepository) {
        this.quizSolveRecordRepository = quizSolveRecordRepository;
    }

    public ResponseEntity<QuizSolveRecordResponseDto> save(QuizSolveRecordRegisterRequestDto quizSolveRecordRegisterRequestDto) {
        QuizSolveRecord quizSolveRecord = quizSolveRecordRegisterRequestDto.toEntity(quizSolveRecordRegisterRequestDto);
        QuizSolveRecord saveddQuizSolveRecord = quizSolveRecordRepository.save(quizSolveRecord);
        return ResponseEntity.ok(QuizSolveRecordResponseDto.fromEntity(saveddQuizSolveRecord));
    }
}