package com.virtukch.dongiveupbe.domain.quiz_solve_record.dto;

import com.virtukch.dongiveupbe.domain.quiz_solve_record.entity.Correct;
import com.virtukch.dongiveupbe.domain.quiz_solve_record.entity.QuizSolveRecord;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QuizSolveRecordResponseDto {

    private Long quizSolveRecordId;

    private Long gameMemberId;

    private Long quizId;

    private Long roundId;

    private Timestamp createdAt;

    private Correct correct;

    private Integer attemptCount;

    private Integer quizCorrectMoney;

    public static QuizSolveRecordResponseDto fromEntity(QuizSolveRecord quizSolveRecord) {
        return QuizSolveRecordResponseDto.builder()
                .quizSolveRecordId(quizSolveRecord.getQuizSolveRecordId())
                .gameMemberId(quizSolveRecord.getGameMemberId())
                .quizId(quizSolveRecord.getQuizId())
                .roundId(quizSolveRecord.getRoundId())
                .createdAt(quizSolveRecord.getCreatedAt())
                .correct(quizSolveRecord.getCorrect())
                .quizCorrectMoney(quizSolveRecord.getQuizCorrectMoney())
                .build();
    }
}
