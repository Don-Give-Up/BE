package com.virtukch.dongiveupbe.quiz_solve_record.repository;

import com.virtukch.dongiveupbe.quiz_solve_record.entity.QuizSolveRecord;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizSolveRecordRepository extends JpaRepository<QuizSolveRecord, Long> {

    List<QuizSolveRecord> findByGameMemberId(Long gameMemberId);
}