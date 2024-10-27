package com.virtukch.dongiveupbe.multiple_choice_view.dto;

import com.virtukch.dongiveupbe.multiple_choice_view.entity.MultipleChoiceView;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MultipleChoiceViewRequestDto {

    private Long quizId;

    private Integer viewIndex;

    private String viewContent;

    public static MultipleChoiceView toEntity(
        MultipleChoiceViewRequestDto multipleChoiceViewRequestDto) {
        return MultipleChoiceView.builder()
            .quizId(multipleChoiceViewRequestDto.quizId)
            .viewIndex(multipleChoiceViewRequestDto.viewIndex)
            .viewContent(multipleChoiceViewRequestDto.viewContent)
            .build();
    }
}
