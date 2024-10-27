package com.virtukch.dongiveupbe.saving_product_status.controller;

import com.virtukch.dongiveupbe.saving_product_status.dto.SavingProductStatusRequestDto;
import com.virtukch.dongiveupbe.saving_product_status.dto.SavingProductStatusResponseDto;
import com.virtukch.dongiveupbe.saving_product_status.service.SavingProductStatusService;
import io.swagger.v3.oas.annotations.Operation;
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
@RequestMapping("api/v1/saving-product-statuses")
@Tag(name = "저축 상품 상태 API", description = "저축 상품의 가격이 라운드마다 바뀌거나, 저축 상품의 가격을 라운드 별로 조회하고 싶을 때 사용하는 API")
public class SavingProductStatusController {

    private final SavingProductStatusService savingProductStatusService;

    @Autowired
    public SavingProductStatusController(SavingProductStatusService savingProductStatusService) {
        this.savingProductStatusService = savingProductStatusService;
    }

    // 1. 저축 상품 전체 조회
    @GetMapping
    @Operation(summary = "저축 상품 전체 조회", description = "모든 저축 상품 상태 정보를 조회합니다.")
    public ResponseEntity<List<SavingProductStatusResponseDto>> findAll() {
        return ResponseEntity.ok(savingProductStatusService.findAll());
    }

    // 2. 라운드 아이디에 따른 저축 상품 전체 조회
    @GetMapping("{roundId}")
    @Operation(summary = "라운드 ID에 따른 저축 상품 조회", description = "특정 라운드 ID에 따른 저축 상품 상태 정보를 조회합니다.")
    public ResponseEntity<List<SavingProductStatusResponseDto>> findByRoundId(
        @PathVariable("roundId") Long roundId) {
        return ResponseEntity.ok(savingProductStatusService.findByRoundId(roundId));
    }

    // 3. 저축 상품 아이디에 따른 저축 상품 조회
    @GetMapping("product/{savingProductId}")
    @Operation(summary = "저축 상품 ID에 따른 상태 조회", description = "특정 저축 상품 ID에 따른 상태 정보를 조회합니다.")
    public ResponseEntity<List<SavingProductStatusResponseDto>> findBySavingProductId(
        @PathVariable("savingProductId") Long savingProductId) {
        return ResponseEntity.ok(savingProductStatusService.findBySavingProductId(savingProductId));
    }

    // 4. 저축 상품 상태 아이디에 따른 단일 조회
    @GetMapping("status/{savingProductStatusId}")
    @Operation(summary = "저축 상품 상태 ID로 단일 조회", description = "특정 저축 상품 상태 ID에 대한 정보를 조회합니다.")
    public ResponseEntity<SavingProductStatusResponseDto> findById(
        @PathVariable Long savingProductStatusId) {
        return ResponseEntity.ok(savingProductStatusService.findById(savingProductStatusId));
    }

    // 5. 저축 상품 추가
    @PostMapping
    @Operation(summary = "저축 상품 상태 추가", description = "새로운 저축 상품 상태를 추가합니다.")
    public ResponseEntity<SavingProductStatusResponseDto> save(
        @RequestBody SavingProductStatusRequestDto savingProductStatusRequestDto) {
        return ResponseEntity.ok(savingProductStatusService.save(savingProductStatusRequestDto));
    }
}
