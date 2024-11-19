package com.virtukch.dongiveupbe.domain.quiz_solve_record.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuizSolveRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quizSolveRecordId;

    private Long gameMemberId;

    private Long quizId;

    private LocalDateTime createdAt;

    private Correct correct;

    private Integer quizCorrectMoney;
}