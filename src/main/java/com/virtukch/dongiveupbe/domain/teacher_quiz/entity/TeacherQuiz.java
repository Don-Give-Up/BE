package com.virtukch.dongiveupbe.domain.teacher_quiz.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherQuiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherQuizId;

    private Long memberId;

    private Long quizId;

    private Integer isStopped;

    @Builder
    public TeacherQuiz(Long memberId, Long quizId, Integer isStopped) {
        this.memberId = memberId;
        this.quizId = quizId;
        this.isStopped = isStopped;
    }
}
