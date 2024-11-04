package com.virtukch.dongiveupbe.domain.quiz.repository;

import com.virtukch.dongiveupbe.domain.quiz.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}