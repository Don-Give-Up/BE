package com.virtukch.dongiveupbe.quiz.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quizNum;

    private Long memberId;                  // XR 에게 보내지 않을 정보

    private String category;

    private String type;

    private String answer;

    private String desc;

    @Setter
    private IsAcceptedByTeacher isAcceptedByTeacher;     // XR 에게 보내지 않을 정보

    private LocalDateTime createdAt;        // XR 에게 보내지 않을 정보

    private LocalDateTime updatedAt;        // XR 에게 보내지 않을 정보

    @Builder
    public Quiz(Long memberId, String category, String type, String answer, String desc,
        IsAcceptedByTeacher isAcceptedByTeacher, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.memberId = memberId;
        this.category = category;
        this.type = type;
        this.answer = answer;
        this.desc = desc;
        this.isAcceptedByTeacher = isAcceptedByTeacher;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}