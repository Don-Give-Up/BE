package com.virtukch.dongiveupbe.multiple_choice_view.controller;

import com.virtukch.dongiveupbe.multiple_choice_view.dto.MultipleChoiceViewResponseDto;
import com.virtukch.dongiveupbe.multiple_choice_view.service.MultipleChoiceViewService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/multiple-choice-views")
public class MultipleChoiceViewController {

    private final MultipleChoiceViewService multipleChoiceViewService;

    @Autowired
    public MultipleChoiceViewController(MultipleChoiceViewService multipleChoiceViewService) {
        this.multipleChoiceViewService = multipleChoiceViewService;
    }

    @GetMapping("{quizId}")
    public ResponseEntity<List<MultipleChoiceViewResponseDto>> findByQuizId(
        @PathVariable("quizId") Long quizId) {
        return multipleChoiceViewService.findByQuizId(quizId);
    }
}