package com.virtukch.dongiveupbe.multiple_choice_view.controller;

import com.virtukch.dongiveupbe.multiple_choice_view.dto.MultipleChoiceViewResponseDto;
import com.virtukch.dongiveupbe.multiple_choice_view.service.MultipleChoiceViewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/multiple-choice-views")
@Tag(name = "객관식 보기 API", description = "문제가 객관식일 경우, 객관식의 보기를 조회하기 위한 API")
public class MultipleChoiceViewController {

    private final MultipleChoiceViewService multipleChoiceViewService;

    @Autowired
    public MultipleChoiceViewController(MultipleChoiceViewService multipleChoiceViewService) {
        this.multipleChoiceViewService = multipleChoiceViewService;
    }

    @GetMapping("{quizId}")
    @Operation(summary = "주어진 퀴즈 ID로 객관식 보기를 조회합니다.",
        description = "특정 퀴즈 ID에 대한 객관식 보기 목록을 반환합니다.")
    public ResponseEntity<List<MultipleChoiceViewResponseDto>> findByQuizId(
        @PathVariable("quizId") Long quizId) {
        return multipleChoiceViewService.findByQuizId(quizId);
    }
}