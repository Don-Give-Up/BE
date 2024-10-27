package com.virtukch.dongiveupbe.saving_product_status.controller;

import com.virtukch.dongiveupbe.saving_product_status.dto.SavingProductStatusRequestDto;
import com.virtukch.dongiveupbe.saving_product_status.dto.SavingProductStatusResponseDto;
import com.virtukch.dongiveupbe.saving_product_status.service.SavingProductStatusService;
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
@RequestMapping("api/v1/saving-product-statuses")
public class SavingProductStatusController {

    private final SavingProductStatusService savingProductStatusService;

    @Autowired
    public SavingProductStatusController(SavingProductStatusService savingProductStatusService) {
        this.savingProductStatusService = savingProductStatusService;
    }

    // 1. 저축 상품 전체 조회 (매 라운드에 세 개 씩 받아 볼 수 있음)
    @GetMapping
    public ResponseEntity<List<SavingProductStatusResponseDto>> findAll() {
        return ResponseEntity.ok(savingProductStatusService.findAll());
    }

    // 2. 라운드 아이디에 따른 저축 상품 전체 조회 (3개)
    @GetMapping("{roundId}")
    public ResponseEntity<List<SavingProductStatusResponseDto>> findByRoundId(
        @PathVariable("roundId") Long roundId) {
        return ResponseEntity.ok(savingProductStatusService.findByRoundId(roundId));
    }

    // 3. 저축 상품 아이디에 따른 저축 상품 전체 조회 (라운드 별 해당 저축 상품의 추이)
    @GetMapping("{savingProductId}")
    public ResponseEntity<List<SavingProductStatusResponseDto>> findBySavingProductId(
        @PathVariable("savingProductId") Long savingProductId) {
        return ResponseEntity.ok(savingProductStatusService.findBySavingProductId(savingProductId));
    }

    // 4. 저축 상품 상태 아이디에 따른 저축 상품 단일 조회 (오직 1개)
    @GetMapping("{savingProductStatusId}")
    public ResponseEntity<SavingProductStatusResponseDto> findById(
        @PathVariable Long savingProductStatusId) {
        return ResponseEntity.ok(savingProductStatusService.findById(savingProductStatusId));
    }

    // 5. 저축 상품 추가
    @PostMapping
    public ResponseEntity<SavingProductStatusResponseDto> save(
        @RequestBody SavingProductStatusRequestDto savingProductStatusRequestDto) {
        return ResponseEntity.ok(savingProductStatusService.save(savingProductStatusRequestDto));
    }
}