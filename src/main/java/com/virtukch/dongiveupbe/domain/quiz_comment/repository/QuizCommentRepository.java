package com.virtukch.dongiveupbe.domain.quiz_comment.repository;

import com.virtukch.dongiveupbe.domain.quiz_comment.entity.QuizComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizCommentRepository extends JpaRepository<QuizComment, Long> {
    List<QuizComment> findByQuizId(Long quizId);
}
