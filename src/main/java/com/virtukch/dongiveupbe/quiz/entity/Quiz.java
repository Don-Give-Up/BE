package com.virtukch.dongiveupbe.quiz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quizId;

    private Long memberNo;

    private Long unitId;

    private String quizTitle;

    private Type type;

    private Answer answer;

    private String quizSubjectiveAnswer;

    private Accept accept;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Long quizLevel;

}
