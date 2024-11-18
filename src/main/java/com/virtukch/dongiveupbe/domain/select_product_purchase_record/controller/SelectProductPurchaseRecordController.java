package com.virtukch.dongiveupbe.domain.select_product_purchase_record.controller;

import com.virtukch.dongiveupbe.domain.select_product_purchase_record.dto.SelectProductPurchaseRecordRequestDto;
import com.virtukch.dongiveupbe.domain.select_product_purchase_record.dto.SelectProductPurchaseRecordResponseDto;
import com.virtukch.dongiveupbe.domain.select_product_purchase_record.service.SelectProductPurchaseRecordService;
import com.virtukch.dongiveupbe.security.common.utils.TokenUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/select-product-purchase-records")
@RequiredArgsConstructor
@Tag(name = "선택 상품 구매 기록 API", description = "선택 상품 구매 기록과 관련된 API를 제공합니다.")
public class SelectProductPurchaseRecordController {

    private final SelectProductPurchaseRecordService purchaseRecordService;

    @PostMapping
    @Operation(
            summary = "선택 상품 구매 기록 생성",
            description = "선택 상품 구매 정보를 저장합니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "구매 기록 생성 성공",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = SelectProductPurchaseRecordResponseDto.class)))
            }
    )
    public ResponseEntity<SelectProductPurchaseRecordResponseDto> save(
            @RequestBody SelectProductPurchaseRecordRequestDto requestDto,
            HttpServletRequest request) {
        Long memberId = TokenUtils.getMemberIdFromRequest(request);
        requestDto.setGameMemberId(memberId);
        SelectProductPurchaseRecordResponseDto response = purchaseRecordService.save(requestDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/member/{memberId}")
    @Operation(
            summary = "특정 멤버의 구매 기록 조회",
            description = "특정 게임 멤버의 구매 기록을 조회합니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "구매 기록 조회 성공",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = SelectProductPurchaseRecordResponseDto.class)))
            }
    )
    public ResponseEntity<List<SelectProductPurchaseRecordResponseDto>> getPurchaseRecordsByStudent(
            @PathVariable Long memberId) {
        List<SelectProductPurchaseRecordResponseDto> responseList = purchaseRecordService.getPurchaseRecordsByGameMemberId(memberId);
        return ResponseEntity.ok(responseList);
    }
}
