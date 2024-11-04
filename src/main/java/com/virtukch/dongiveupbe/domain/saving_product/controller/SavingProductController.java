package com.virtukch.dongiveupbe.domain.saving_product.controller;

import com.virtukch.dongiveupbe.domain.saving_product.entity.SavingProduct;
import com.virtukch.dongiveupbe.domain.saving_product.service.SavingProductService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Hidden
@RestController
@RequestMapping("api/v1/saving-product")
@Tag(name = "저축 상품 API", description = "이름이 다르거나 정책이 다른 저축 상품을 추가하거나, 저축 상품을 조회할 때 사용할 수 있는 API")
public class SavingProductController {

    private final SavingProductService savingProductService;

    @Autowired
    public SavingProductController(SavingProductService savingProductService) {
        this.savingProductService = savingProductService;
    }

    // 1. 저축 상품 전체 조회
    @GetMapping
    @Operation(summary = "저축 상품 전체 조회", description = "모든 저축 상품 정보를 조회합니다.")
    public ResponseEntity<List<SavingProduct>> findAll() {
        return ResponseEntity.ok(savingProductService.findAll());
    }

    // 2. 저축 상품 이름으로 조회
    @GetMapping("/name/{savingProductName}")
    @Operation(summary = "저축 상품 이름으로 조회", description = "저축 상품 이름으로 특정 상품 정보를 조회합니다.")
    public ResponseEntity<SavingProduct> findBySavingProductName(
        @PathVariable String savingProductName) {
        return ResponseEntity.ok(savingProductService.findBySavingProductName(savingProductName));
    }

    // 3. 저축 상품 아이디로 조회
    @GetMapping("/{savingProductId}")
    @Operation(summary = "저축 상품 아이디로 조회", description = "저축 상품 ID로 특정 상품 정보를 조회합니다.")
    public ResponseEntity<SavingProduct> findById(@PathVariable Long savingProductId) {
        return ResponseEntity.ok(savingProductService.findById(savingProductId));
    }
}