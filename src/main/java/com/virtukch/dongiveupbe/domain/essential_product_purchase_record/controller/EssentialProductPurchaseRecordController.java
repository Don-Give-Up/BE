package com.virtukch.dongiveupbe.domain.essential_product_purchase_record.controller;

import com.virtukch.dongiveupbe.domain.essential_product_purchase_record.dto.EssentialProductPurchaseRecordRequestDto;
import com.virtukch.dongiveupbe.domain.essential_product_purchase_record.dto.EssentialProductPurchaseRecordResponseDto;
import com.virtukch.dongiveupbe.domain.essential_product_purchase_record.service.EssentialProductPurchaseRecordService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/essential-product-purchase-records")
@Tag(name = "필수 상품 구매 내역 API")
public class EssentialProductPurchaseRecordController {

    private final EssentialProductPurchaseRecordService purchaseRecordService;

    @Autowired
    public EssentialProductPurchaseRecordController(
        EssentialProductPurchaseRecordService purchaseRecordService) {
        this.purchaseRecordService = purchaseRecordService;
    }

    // 구매 기록 추가
    @PostMapping
    @Operation(summary = "필수 상품을 구매할 때 호출해 주세요", description = "essentialProductStatusId 는 필수 상품의 가격이 바뀔 때 나오는 ID 입니다.")
    public ResponseEntity<Void> recordPurchase(
        @RequestBody EssentialProductPurchaseRecordRequestDto requestDto) {
        purchaseRecordService.recordPurchase(requestDto);
        return ResponseEntity.ok().build();
    }

    // 특정 회원의 구매 내역 조회
    @Hidden
    @GetMapping("/game-member/{gameMemberId}")
    @Operation(summary = "특정 회원의 구매 내역 조회", description = "특정 회원의 필수 상품 구매 내역을 조회합니다.")
    @ApiResponse(responseCode = "200", description = "구매 내역 조회 성공",
        content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = EssentialProductPurchaseRecordResponseDto.class)))
    public ResponseEntity<List<EssentialProductPurchaseRecordResponseDto>> getPurchaseRecordsByMember(
        @PathVariable Long gameMemberId) {
        List<EssentialProductPurchaseRecordResponseDto> records = purchaseRecordService.getPurchaseRecordsByMember(
            gameMemberId);
        return ResponseEntity.ok(records);
    }
}