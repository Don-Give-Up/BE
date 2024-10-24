package com.virtukch.dongiveupbe.quiz.service;

import com.virtukch.dongiveupbe.quiz.dto.QuizResponseDto;
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

    public List<QuizResponseDto> findAll() {
        return quizRepository.findAll().stream()
            .map(quiz -> QuizResponseDto.builder()
                .memberId(quiz.getMemberId())
                .unitId(quiz.getUnitId())
                .quizTitle(quiz.getQuizTitle())
                .quizType(quiz.getQuizType())
                .multipleChoiceQuizAnswer(quiz.getMultipleChoiceQuizAnswer())
                .oxQuizAnswer(quiz.getOxQuizAnswer())
                .multipleChoiceQuizAnswer(quiz.getMultipleChoiceQuizAnswer())
                .isAcceptedByTeacher(quiz.getIsAcceptedByTeacher())
                .createdAt(quiz.getCreatedAt())
                .updatedAt(quiz.getUpdatedAt())
                .quizLevel(quiz.getQuizLevel())
                .build())
            .toList();
    }
}