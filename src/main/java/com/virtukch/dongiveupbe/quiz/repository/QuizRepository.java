package com.virtukch.dongiveupbe.quiz.repository;

import com.virtukch.dongiveupbe.quiz.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}