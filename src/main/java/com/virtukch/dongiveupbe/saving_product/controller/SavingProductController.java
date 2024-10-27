package com.virtukch.dongiveupbe.saving_product.controller;

import com.virtukch.dongiveupbe.saving_product.entity.SavingProduct;
import com.virtukch.dongiveupbe.saving_product.service.SavingProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/saving-product")
public class SavingProductController {

    private final SavingProductService savingProductService;

    @Autowired
    public SavingProductController(SavingProductService savingProductService) {
        this.savingProductService = savingProductService;
    }

    // 1. 저축 상품 전체 조회
    @GetMapping
    public ResponseEntity<List<SavingProduct>> findAll() {
        return ResponseEntity.ok(savingProductService.findAll());
    }

    // 2. 저축 상품 이름으로 조회
    @GetMapping("/{savingProductName}")
    public ResponseEntity<SavingProduct> findBySavingProductName(@PathVariable String savingProductName) {
        return ResponseEntity.ok(savingProductService.findBySavingProductName(savingProductName));
    }

    // 3. 저축 상품 아이디로 조회
    @GetMapping("/{savingProductId}")
    public ResponseEntity<SavingProduct> findById(@PathVariable Long savingProductId) {
        return ResponseEntity.ok(savingProductService.findById(savingProductId));
    }
}