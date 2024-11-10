package com.virtukch.dongiveupbe.domain.teacher_quiz.repository;

import com.virtukch.dongiveupbe.domain.teacher_quiz.entity.TeacherQuiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeacherQuizRepository extends JpaRepository<TeacherQuiz, Long> {
    List<TeacherQuiz> findByMemberId(Long memberId);

    Optional<TeacherQuiz> findByQuizId(Long quizId);

    List<TeacherQuiz> findByGameId(Long gameId);
}
