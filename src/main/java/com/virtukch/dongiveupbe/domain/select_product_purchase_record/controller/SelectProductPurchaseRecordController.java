package com.virtukch.dongiveupbe.domain.select_product_purchase_record.controller;

import com.virtukch.dongiveupbe.domain.select_product_purchase_record.dto.SelectProductPurchaseRecordRequestDto;
import com.virtukch.dongiveupbe.domain.select_product_purchase_record.dto.SelectProductPurchaseRecordResponseDto;
import com.virtukch.dongiveupbe.domain.select_product_purchase_record.service.SelectProductPurchaseRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase-records")
@RequiredArgsConstructor
public class SelectProductPurchaseRecordController {

    private final SelectProductPurchaseRecordService purchaseRecordService;

    @PostMapping
    public ResponseEntity<SelectProductPurchaseRecordResponseDto> save(
            @RequestBody SelectProductPurchaseRecordRequestDto requestDto) {
        SelectProductPurchaseRecordResponseDto response = purchaseRecordService.save(requestDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/student/{gameMemberId}")
    public ResponseEntity<List<SelectProductPurchaseRecordResponseDto>> getPurchaseRecordsByStudent(
            @PathVariable Long gameMemberId) {
        List<SelectProductPurchaseRecordResponseDto> responseList = purchaseRecordService.getPurchaseRecordsByStudent(gameMemberId);
        return ResponseEntity.ok(responseList);
    }
}
