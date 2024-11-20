package com.virtukch.dongiveupbe.domain.quiz_solve_record.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.virtukch.dongiveupbe.domain.quiz_solve_record.entity.Correct;
import com.virtukch.dongiveupbe.domain.quiz_solve_record.entity.QuizSolveRecord;
import java.sql.Timestamp;
import java.time.LocalDateTime;

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

    private Long gameId;

    private Long gameMemberId;

    private Long quizId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    private Correct correct;

    private Integer quizCorrectMoney;

    public static QuizSolveRecordResponseDto fromEntity(QuizSolveRecord quizSolveRecord) {
        return QuizSolveRecordResponseDto.builder()
                .gameId(quizSolveRecord.getGameId())
                .quizSolveRecordId(quizSolveRecord.getQuizSolveRecordId())
                .gameMemberId(quizSolveRecord.getGameMemberId())
                .quizId(quizSolveRecord.getQuizId())
                .createdAt(quizSolveRecord.getCreatedAt())
                .correct(quizSolveRecord.getCorrect())
                .quizCorrectMoney(quizSolveRecord.getQuizCorrectMoney())
                .build();
    }
}
