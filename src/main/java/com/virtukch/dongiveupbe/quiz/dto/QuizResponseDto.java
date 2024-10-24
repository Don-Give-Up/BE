package com.virtukch.dongiveupbe.quiz.dto;

import com.virtukch.dongiveupbe.quiz.entity.IsAcceptedByTeacher;
import com.virtukch.dongiveupbe.quiz.entity.MultipleChoiceQuizAnswer;
import com.virtukch.dongiveupbe.quiz.entity.OXQuizAnswer;
import com.virtukch.dongiveupbe.quiz.entity.QuizType;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class QuizResponseDto {

    private Long memberId;

    private Long unitId;

    private String quizTitle;

    private QuizType quizType;

    private OXQuizAnswer oxQuizAnswer;

    private MultipleChoiceQuizAnswer multipleChoiceQuizAnswer;

    private String subjectiveQuizAnswer;

    private IsAcceptedByTeacher isAcceptedByTeacher;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Long quizLevel;

    @Builder
    public QuizResponseDto(Long memberId, Long unitId, String quizTitle, QuizType quizType,
        OXQuizAnswer oxQuizAnswer, MultipleChoiceQuizAnswer multipleChoiceQuizAnswer,
        String subjectiveQuizAnswer, IsAcceptedByTeacher isAcceptedByTeacher,
        LocalDateTime createdAt,
        LocalDateTime updatedAt, Long quizLevel) {
        this.memberId = memberId;
        this.unitId = unitId;
        this.quizTitle = quizTitle;
        this.quizType = quizType;
        this.oxQuizAnswer = oxQuizAnswer;
        this.multipleChoiceQuizAnswer = multipleChoiceQuizAnswer;
        this.subjectiveQuizAnswer = subjectiveQuizAnswer;
        this.isAcceptedByTeacher = isAcceptedByTeacher;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.quizLevel = quizLevel;
    }
}
