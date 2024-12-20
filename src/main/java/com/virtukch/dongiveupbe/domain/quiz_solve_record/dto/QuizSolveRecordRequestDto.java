package com.virtukch.dongiveupbe.domain.quiz_solve_record.dto;

import com.virtukch.dongiveupbe.domain.quiz_solve_record.entity.Correct;
import com.virtukch.dongiveupbe.domain.quiz_solve_record.entity.QuizSolveRecord;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QuizSolveRecordRequestDto {

    @Setter
    @Hidden
    private Long gameMemberId;

    private  Long gameId;

    private Long quizId;
    @Hidden
    private LocalDateTime createdAt;

    private Correct correct;

    public QuizSolveRecord toEntity() {
        return QuizSolveRecord.builder()
                .gameMemberId(this.gameMemberId)
                .gameId(this.gameId)
                .quizId(this.quizId)
                .createdAt(this.createdAt != null ? this.createdAt : LocalDateTime.now())
                .correct(this.correct)
                .quizCorrectMoney(0)
                .build();
    }
}