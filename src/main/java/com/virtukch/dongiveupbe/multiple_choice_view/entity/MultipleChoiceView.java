package com.virtukch.dongiveupbe.multiple_choice_view.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class MultipleChoiceView {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long viewId;

    private Long quizId;

    private Integer viewIndex;

    private String viewContent;

    @Builder
    public MultipleChoiceView(Long quizId, Integer viewIndex, String viewContent) {
        this.quizId = quizId;
        this.viewIndex = viewIndex;
        this.viewContent = viewContent;
    }
}