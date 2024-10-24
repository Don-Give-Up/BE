package com.virtukch.dongiveupbe.multiple_choice_view.dto;

import com.virtukch.dongiveupbe.multiple_choice_view.entity.MultipleChoiceView;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MultipleChoiceViewResponseDto {

    private Integer viewIndex;

    private String viewContent;

    public static MultipleChoiceViewResponseDto fromEntity(MultipleChoiceView multipleChoiceView) {
        return MultipleChoiceViewResponseDto.builder()
            .viewIndex(multipleChoiceView.getViewIndex())
            .viewContent(multipleChoiceView.getViewContent())
            .build();
    }
}
