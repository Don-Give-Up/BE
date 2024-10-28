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

    private Long gameMemberId;

    private Long quizId;

    private Long roundId;

    private Timestamp createdAt;

    private Correct correct;

    public static QuizSolveRecord toEntity(
        QuizSolveRecordRequestDto quizSolveRecordRequestDto) {
        return QuizSolveRecord.builder()
            .gameMemberId(quizSolveRecordRequestDto.getGameMemberId())
            .quizId(quizSolveRecordRequestDto.getQuizId())
            .roundId(quizSolveRecordRequestDto.getRoundId())
            .createdAt(quizSolveRecordRequestDto.getCreatedAt())
            .correct(quizSolveRecordRequestDto.getCorrect())
            .build();
    }
}