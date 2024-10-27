package com.virtukch.dongiveupbe.quiz_solve_record.dto;

import com.virtukch.dongiveupbe.quiz.entity.Quiz;
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
public class QuizSolveRecordResponseDto {

    private Long gameMemberId;

    private Long quizId;

    private Long roundId;

    private Timestamp createdAt;

    private Correct correct;

    private Integer attemptCount;

    public static QuizSolveRecordResponseDto fromEntity(QuizSolveRecord quizSolveRecord) {
        return QuizSolveRecordResponseDto.builder()
            .gameMemberId(quizSolveRecord.getGameMemberId())
            .quizId(quizSolveRecord.getQuizId())
            .roundId(quizSolveRecord.getRoundId())
            .createdAt(quizSolveRecord.getCreatedAt())
            .correct(quizSolveRecord.getCorrect())
            .attemptCount(quizSolveRecord.getAttemptCount())
            .build();
    }
}
