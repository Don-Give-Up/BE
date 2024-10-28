package com.virtukch.dongiveupbe.quiz.service;

import com.virtukch.dongiveupbe.quiz.dto.QuizRequestDto;
import com.virtukch.dongiveupbe.quiz.dto.QuizResponseDto;
import com.virtukch.dongiveupbe.quiz.entity.Quiz;
import com.virtukch.dongiveupbe.quiz.repository.QuizRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

    private final QuizRepository quizRepository;

    @Autowired
    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public ResponseEntity<List<QuizResponseDto>> findAll() {
        return ResponseEntity.ok(quizRepository.findAll().stream()
            .map(QuizResponseDto::fromEntity)
            .toList());
    }

    public ResponseEntity<QuizResponseDto> findById(Long quizId) {
        Quiz quiz = quizRepository.findById(quizId).orElse(null);

        if (quiz == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(QuizResponseDto.fromEntity(quiz));
    }

    public QuizResponseDto save(QuizRequestDto quizRequestDto) {
        Quiz quiz = quizRepository.save(QuizRequestDto.toEntity(quizRequestDto));
        return QuizResponseDto.fromEntity(quiz);
    }
}