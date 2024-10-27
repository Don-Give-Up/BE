package com.virtukch.dongiveupbe.quiz_solve_record.dto;

import com.virtukch.dongiveupbe.quiz_solve_record.entity.Correct;
import com.virtukch.dongiveupbe.quiz_solve_record.entity.QuizSolveRecord;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QuizSolveRecordRequestDto {

    private Long quizSolveRecordId;

    private Long gameMemberId;

    private Long quizId;

    private Long roundId;

    private Timestamp createdAt;

    private Correct correct;

    private Integer attemptCount;

    public QuizSolveRecord toEntity(
        QuizSolveRecordRequestDto quizSolveRecordRequestDto) {
        return QuizSolveRecord.builder()
            .quizSolveRecordId(quizSolveRecordRequestDto.getQuizSolveRecordId())
            .gameMemberId(quizSolveRecordRequestDto.getGameMemberId())
            .quizId(quizSolveRecordRequestDto.getQuizId())
            .roundId(quizSolveRecordRequestDto.getRoundId())
            .createdAt(quizSolveRecordRequestDto.getCreatedAt())
            .correct(quizSolveRecordRequestDto.getCorrect())
            .attemptCount(quizSolveRecordRequestDto.getAttemptCount())
            .build();
    }
}