package com.virtukch.dongiveupbe.quiz.service;

import com.virtukch.dongiveupbe.quiz.dto.QuizRequestDto;
import com.virtukch.dongiveupbe.quiz.dto.QuizResponseDto;
import com.virtukch.dongiveupbe.quiz.exception.QuizNotFoundException;
import com.virtukch.dongiveupbe.quiz.repository.QuizRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

    private final QuizRepository quizRepository;

    @Autowired
    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    // 1. 퀴즈 전체 조회
    public List<QuizResponseDto> findAll() {
        return quizRepository.findAll().stream().map(QuizResponseDto::fromEntity).toList();
    }

    // 2. 퀴즈 아이디로 조회
    public QuizResponseDto findById(Long id) {
        return QuizResponseDto.fromEntity(quizRepository.findById(id)
            .orElseThrow(() -> new QuizNotFoundException("해당 아이디와 일치하는 퀴즈가 존재하지 않습니다.")));
    }

    // 3. 퀴즈 단일 생성
    public QuizResponseDto save(QuizRequestDto quizRequestDto) {
        return QuizResponseDto.fromEntity(
            quizRepository.save(QuizRequestDto.toEntity(quizRequestDto)));
    }
}