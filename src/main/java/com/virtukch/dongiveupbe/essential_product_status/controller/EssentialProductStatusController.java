package com.virtukch.dongiveupbe.essential_product_status.controller;

import com.virtukch.dongiveupbe.essential_product_status.dto.EssentialProductStatusRegisterRequestDto;
import com.virtukch.dongiveupbe.essential_product_status.dto.EssentialProductStatusResponseDto;
import com.virtukch.dongiveupbe.essential_product_status.service.EssentialProductStatusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/essential-product-status")
public class EssentialProductStatusController {

    private final EssentialProductStatusService productStatusService;

    public EssentialProductStatusController(EssentialProductStatusService productStatusService) {
        this.productStatusService = productStatusService;
    }

    // 특정 라운드에 대한 모든 상품 상태 조회
    @GetMapping("/round/{roundId}")
    public ResponseEntity<List<EssentialProductStatusResponseDto>> getProductStatusByRound(@PathVariable Long roundId) {
        List<EssentialProductStatusResponseDto> productStatusList = productStatusService.getProductStatusByRound(roundId);
        return ResponseEntity.ok(productStatusList);
    }

    // 상품 상태 생성
    @PostMapping
    public ResponseEntity<EssentialProductStatusResponseDto> createProductStatus(
            @RequestBody EssentialProductStatusRegisterRequestDto requestDto) {
        EssentialProductStatusResponseDto createdProductStatus = productStatusService.save(requestDto);
        return ResponseEntity.ok(createdProductStatus);
    }

    // 상품 상태의 갯수 업데이트
    @PutMapping("/{statusId}/amount")
    public ResponseEntity<EssentialProductStatusResponseDto> updateProductStatusAmount(
            @PathVariable Long statusId,
            @RequestParam Long amount) {
        EssentialProductStatusResponseDto updatedProductStatus = productStatusService.updateProductStatusAmount(statusId, amount);
        return ResponseEntity.ok(updatedProductStatus);
    }

    @GetMapping
    public ResponseEntity<List<EssentialProductStatusResponseDto>> getAllProductStatuses() {
        List<EssentialProductStatusResponseDto> productStatuses = productStatusService.getAllProductStatuses();
        return ResponseEntity.ok(productStatuses);
    }

}
