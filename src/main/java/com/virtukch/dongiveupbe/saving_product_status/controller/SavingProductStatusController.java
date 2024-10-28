package com.virtukch.dongiveupbe.saving_product_status.controller;

import com.virtukch.dongiveupbe.saving_product_status.dto.SavingProductStatusRequestDto;
import com.virtukch.dongiveupbe.saving_product_status.dto.SavingProductStatusResponseDto;
import com.virtukch.dongiveupbe.saving_product_status.service.SavingProductStatusService;
import io.swagger.v3.oas.annotations.Hidden;
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
@Tag(name = "저축 상품 상태 API", description = "각 라운드 별로 저축 상품의 이자가 바뀔 때마다 호출하는 API 입니다.")
public class SavingProductStatusController {

    private final SavingProductStatusService savingProductStatusService;

    @Autowired
    public SavingProductStatusController(SavingProductStatusService savingProductStatusService) {
        this.savingProductStatusService = savingProductStatusService;
    }

    // 1. 저축 상품 전체 조회
    @GetMapping
    @Operation(summary = "저축 상품 상태 조회", description = "모든 저축 상품 상태 정보를 조회합니다.")
    public ResponseEntity<List<SavingProductStatusResponseDto>> findAll() {
        return ResponseEntity.ok(savingProductStatusService.findAll());
    }

    // 2. 라운드 아이디에 따른 저축 상품 전체 조회
    @Hidden
    @GetMapping("{roundId}")
    @Operation(summary = "라운드 ID에 따른 저축 상품 조회", description = "특정 라운드 ID에 따른 저축 상품 상태 정보를 조회합니다.")
    public ResponseEntity<List<SavingProductStatusResponseDto>> findByRoundId(
        @PathVariable("roundId") Long roundId) {
        return ResponseEntity.ok(savingProductStatusService.findByRoundId(roundId));
    }

    // 3. 저축 상품 아이디에 따른 저축 상품 조회
    @Hidden
    @GetMapping("product/{savingProductId}")
    @Operation(summary = "저축 상품 ID에 따른 상태 조회", description = "특정 저축 상품 ID에 따른 상태 정보를 조회합니다.")
    public ResponseEntity<List<SavingProductStatusResponseDto>> findBySavingProductId(
        @PathVariable("savingProductId") Long savingProductId) {
        return ResponseEntity.ok(savingProductStatusService.findBySavingProductId(savingProductId));
    }

    // 4. 저축 상품 상태 아이디에 따른 단일 조회
    @Hidden
    @GetMapping("status/{savingProductStatusId}")
    @Operation(summary = "저축 상품 상태 ID로 단일 조회", description = "특정 저축 상품 상태 ID에 대한 정보를 조회합니다.")
    public ResponseEntity<SavingProductStatusResponseDto> findById(
        @PathVariable Long savingProductStatusId) {
        return ResponseEntity.ok(savingProductStatusService.findById(savingProductStatusId));
    }

    // 5. 저축 상품 추가
    @PostMapping
    @Operation(summary = "저축 상품의 이자가 라운드마다 바뀔 때마다 호출해 주세요.", description = "저축 상품 상태 아이디는 api/v1/saving-product-statuses 에서 확인할 수 있습니다.")
    public ResponseEntity<SavingProductStatusResponseDto> save(
        @RequestBody SavingProductStatusRequestDto savingProductStatusRequestDto) {
        return ResponseEntity.ok(savingProductStatusService.save(savingProductStatusRequestDto));
    }
}
