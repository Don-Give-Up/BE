package com.virtukch.dongiveupbe.domain.quiz.repository;

import com.virtukch.dongiveupbe.domain.quiz.entity.Quiz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    Page<Quiz> findByQuizTitleContainingIgnoreCase(String keyword, Pageable pageable);
    Page<Quiz> findByQuizCategoryContainingIgnoreCase(String keyword, Pageable pageable);
    Page<Quiz> findByQuizLevelContainingIgnoreCase(String keyword, Pageable pageable);

    @Query("SELECT q FROM Quiz q WHERE " +
            "LOWER(q.quizTitle) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(q.quizCategory) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(q.quizLevel) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    Page<Quiz> findByAllFields(@Param("keyword") String keyword, Pageable pageable);

}