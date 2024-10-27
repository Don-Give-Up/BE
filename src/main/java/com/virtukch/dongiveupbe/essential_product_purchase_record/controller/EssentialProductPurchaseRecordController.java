package com.virtukch.dongiveupbe.essential_product_purchase_record.controller;

import com.virtukch.dongiveupbe.essential_product_purchase_record.dto.EssentialProductPurchaseRecordRegisterRequestDto;
import com.virtukch.dongiveupbe.essential_product_purchase_record.dto.EssentialProductPurchaseRecordResponseDto;
import com.virtukch.dongiveupbe.essential_product_purchase_record.service.EssentialProductPurchaseRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/essential-product-purchase-records")
@Tag(name = "필수 상품 구매 내역 API", description = "필수 상품 구매 내역 관리를 위한 API")
public class EssentialProductPurchaseRecordController {

    private final EssentialProductPurchaseRecordService purchaseRecordService;

    public EssentialProductPurchaseRecordController(EssentialProductPurchaseRecordService purchaseRecordService) {
        this.purchaseRecordService = purchaseRecordService;
    }

    // 특정 회원의 구매 내역 조회
    @GetMapping("/game-member/{gameMemberId}")
    @Operation(summary = "특정 회원의 구매 내역 조회", description = "특정 회원의 필수 상품 구매 내역을 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "구매 내역 조회 성공",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EssentialProductPurchaseRecordResponseDto.class)))
    })
    public ResponseEntity<List<EssentialProductPurchaseRecordResponseDto>> getPurchaseRecordsByMember(@PathVariable Long gameMemberId) {
        List<EssentialProductPurchaseRecordResponseDto> records = purchaseRecordService.getPurchaseRecordsByMember(gameMemberId);
        return ResponseEntity.ok(records);
    }

    // 구매 기록 추가
    @PostMapping
    @Operation(summary = "구매 기록 추가", description = "새로운 필수 상품 구매 기록을 추가합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "구매 기록 추가 성공")
    })
    public ResponseEntity<Void> recordPurchase(@RequestBody EssentialProductPurchaseRecordRegisterRequestDto requestDto) {
        purchaseRecordService.recordPurchase(requestDto);
        return ResponseEntity.ok().build();
    }
}
