package com.virtukch.dongiveupbe.essential_product_purchase_record.controller;

import com.virtukch.dongiveupbe.essential_product_purchase_record.dto.EssentialProductPurchaseRecordRegisterRequestDto;
import com.virtukch.dongiveupbe.essential_product_purchase_record.dto.EssentialProductPurchaseRecordResponseDto;
import com.virtukch.dongiveupbe.essential_product_purchase_record.service.EssentialProductPurchaseRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase-records")
public class EssentialProductPurchaseRecordController {

    private final EssentialProductPurchaseRecordService purchaseRecordService;

    public EssentialProductPurchaseRecordController(EssentialProductPurchaseRecordService purchaseRecordService) {
        this.purchaseRecordService = purchaseRecordService;
    }

    // 특정 회원의 구매 내역 조회
    @GetMapping("/member/{gameMemberId}")
    public ResponseEntity<List<EssentialProductPurchaseRecordResponseDto>> getPurchaseRecordsByMember(@PathVariable Long gameMemberId) {
        List<EssentialProductPurchaseRecordResponseDto> records = purchaseRecordService.getPurchaseRecordsByMember(gameMemberId);
        return ResponseEntity.ok(records);
    }

    // 특정 상품 상태와 회원의 구매 내역 조회
    @GetMapping("/status/{essentialProductStatusId}/member/{gameMemberId}")
    public ResponseEntity<List<EssentialProductPurchaseRecordResponseDto>> getPurchaseRecordsByStatusAndMember(
            @PathVariable Long essentialProductStatusId,
            @PathVariable Long gameMemberId) {
        List<EssentialProductPurchaseRecordResponseDto> records = purchaseRecordService.getPurchaseRecordsByStatusAndMember(essentialProductStatusId, gameMemberId);
        return ResponseEntity.ok(records);
    }

    // 구매 기록 추가
    @PostMapping
    public ResponseEntity<Void> recordPurchase(@RequestBody EssentialProductPurchaseRecordRegisterRequestDto requestDto) {
        purchaseRecordService.recordPurchase(requestDto);
        return ResponseEntity.ok().build();
    }
}
