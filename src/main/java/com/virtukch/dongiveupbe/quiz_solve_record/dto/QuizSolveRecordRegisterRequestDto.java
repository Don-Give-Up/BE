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
public class QuizSolveRecordRegisterRequestDto {

    private Long gameMemberId;

    private Long quizId;

    private Long roundId;

    private Timestamp createdAt;

    private Correct correct;

    private Integer attemptCount;

    public QuizSolveRecord toEntity(
        QuizSolveRecordRegisterRequestDto quizSolveRecordRegisterRequestDto) {
        return QuizSolveRecord.builder()
            .gameMemberId(quizSolveRecordRegisterRequestDto.getGameMemberId())
            .quizId(quizSolveRecordRegisterRequestDto.getQuizId())
            .roundId(quizSolveRecordRegisterRequestDto.getRoundId())
            .createdAt(quizSolveRecordRegisterRequestDto.getCreatedAt())
            .correct(quizSolveRecordRegisterRequestDto.getCorrect())
            .attemptCount(quizSolveRecordRegisterRequestDto.getAttemptCount())
            .build();
    }
}