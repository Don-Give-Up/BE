package com.virtukch.dongiveupbe.multiple_choice_view.controller;

import com.virtukch.dongiveupbe.multiple_choice_view.dto.MultipleChoiceViewResponseDto;
import com.virtukch.dongiveupbe.multiple_choice_view.service.MultipleChoiceViewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(
        summary = "주어진 퀴즈 ID로 객관식 보기를 조회합니다.",
        description = "특정 퀴즈 ID에 대한 객관식 보기 목록을 반환합니다.",
        parameters = {
            @Parameter(name = "quizId", description = "조회할 퀴즈의 ID", required = true)
        }
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "객관식 보기 조회 성공",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = MultipleChoiceViewResponseDto.class))),
        @ApiResponse(responseCode = "404", description = "해당 퀴즈 ID에 대한 객관식 보기가 없음",
            content = @Content),
        @ApiResponse(responseCode = "400", description = "잘못된 요청 (예: 잘못된 quizId 형식)",
            content = @Content)
    })
    public ResponseEntity<List<MultipleChoiceViewResponseDto>> findByQuizId(
        @PathVariable("quizId") Long quizId) {
        return multipleChoiceViewService.findByQuizId(quizId);
    }
}