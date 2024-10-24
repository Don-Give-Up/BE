package com.virtukch.dongiveupbe.multiple_choice_view.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MultipleChoiceViewRegisterRequestDto {

    private Long quizId;

    private Integer viewIndex;

    private String viewContent;
}
