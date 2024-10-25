package com.virtukch.dongiveupbe.multiple_choice_view.dto;

import com.virtukch.dongiveupbe.multiple_choice_view.entity.MultipleChoiceView;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MultipleChoiceViewRegisterRequestDto {

    private Long quizId;

    private Integer viewIndex;

    private String viewContent;

    public static MultipleChoiceView toEntity(MultipleChoiceViewRegisterRequestDto multipleChoiceViewRegisterRequestDto) {
        return MultipleChoiceView.builder()
            .quizId(multipleChoiceViewRegisterRequestDto.quizId)
            .viewIndex(multipleChoiceViewRegisterRequestDto.viewIndex)
            .viewContent(multipleChoiceViewRegisterRequestDto.viewContent)
            .build();
    }
}
