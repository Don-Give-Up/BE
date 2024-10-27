package com.virtukch.dongiveupbe.quiz_solve_record.repository;

import com.virtukch.dongiveupbe.quiz_solve_record.entity.QuizSolveRecord;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizSolveRecordRepository extends JpaRepository<QuizSolveRecord, Long> {

    List<QuizSolveRecord> findByGameMemberId(Long gameMemberId);

    // 새로운 메서드: 특정 기간 동안의 퀴즈 풀이 기록을 찾기 위해 정의
    List<QuizSolveRecord> findByGameMemberIdAndRoundIdAndCreatedAtBetween(
            Long gameMemberId, Long roundId, Timestamp start, Timestamp end);

    // 특정 게임 멤버 ID와 라운드 ID에 대한 문제 풀이 기록을 찾기 위한 메서드
    List<QuizSolveRecord> findByGameMemberIdAndRoundId(Long gameMemberId, Long roundId);
}