package com.virtukch.dongiveupbe.quiz.service;

import com.virtukch.dongiveupbe.quiz.QuizNotFoundException;
import com.virtukch.dongiveupbe.quiz.dto.QuizRequestDto;
import com.virtukch.dongiveupbe.quiz.dto.QuizResponseDto;
import com.virtukch.dongiveupbe.quiz.dto.QuizSystemRequestDto;
import com.virtukch.dongiveupbe.quiz.entity.Quiz;
import com.virtukch.dongiveupbe.quiz.repository.QuizRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

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

    // 4. 퀴즈 더미 생성
    public List<QuizResponseDto> saveAll(List<QuizSystemRequestDto> quizSystemRequestDtoList) {

        List<QuizResponseDto> quizResponseDtoList = new ArrayList<>();

        for (QuizSystemRequestDto quizSystemRequestDto : quizSystemRequestDtoList) {
            Quiz quiz = quizRepository.save(QuizSystemRequestDto.toEntity(quizSystemRequestDto));
            quizResponseDtoList.add(QuizResponseDto.fromEntity(quiz));
        }

        return quizResponseDtoList;
    }
}