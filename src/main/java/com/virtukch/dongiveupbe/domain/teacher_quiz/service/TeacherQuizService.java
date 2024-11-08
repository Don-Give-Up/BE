package com.virtukch.dongiveupbe.domain.teacher_quiz.service;

import com.virtukch.dongiveupbe.domain.teacher_quiz.dto.TeacherQuizRequestDto;
import com.virtukch.dongiveupbe.domain.teacher_quiz.dto.TeacherQuizResponseDto;
import com.virtukch.dongiveupbe.domain.teacher_quiz.entity.TeacherQuiz;
import com.virtukch.dongiveupbe.domain.teacher_quiz.exception.QuizNotFoundException;
import com.virtukch.dongiveupbe.domain.teacher_quiz.repository.TeacherQuizRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeacherQuizService {
    private final TeacherQuizRepository teacherQuizRepository;

    public TeacherQuizService(TeacherQuizRepository teacherQuizRepository) {
        this.teacherQuizRepository = teacherQuizRepository;
    }

    // 1. 특정 선생님 id로 가지고 있는 퀴즈 전체 조회
    public List<TeacherQuizResponseDto> findAll(Long memberId) {
        return teacherQuizRepository.findByMemberId(memberId)
                .stream()
                .map(TeacherQuizResponseDto::fromEntity)
                .toList();
    }

    // 2. 퀴즈 추가
    @Transactional
    public TeacherQuizResponseDto save(Long memberId, TeacherQuizRequestDto requestDto) {
        TeacherQuiz teacherQuiz = TeacherQuizRequestDto.toEntity(memberId, requestDto);
        TeacherQuiz saved = teacherQuizRepository.save(teacherQuiz);
        return TeacherQuizResponseDto.fromEntity(saved);
    }

    // 3. 퀴즈 삭제
    @Transactional
    public void delete(Long quizId) {
        TeacherQuiz teacherQuiz = teacherQuizRepository.findByQuizId(quizId)
                .orElseThrow(() -> new QuizNotFoundException("해당 quizId로 퀴즈를 찾을 수 없습니다" + quizId));
        teacherQuizRepository.delete(teacherQuiz);
    }

}
