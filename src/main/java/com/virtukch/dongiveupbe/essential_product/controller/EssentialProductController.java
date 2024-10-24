package com.virtukch.dongiveupbe.essential_product.controller;

import com.virtukch.dongiveupbe.essential_product.dto.EssentialProductResponseDto;
import com.virtukch.dongiveupbe.essential_product.service.EssentialProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.virtukch.dongiveupbe.essential_product.dto.EssentialProductRegisterRequestDto;


@RestController
@RequestMapping("/api/essential-products")
public class EssentialProductController {

    private final EssentialProductService essentialProductService;

    public EssentialProductController(EssentialProductService essentialProductService) {
        this.essentialProductService = essentialProductService;
    }

    // 전체 상품 조회
    @GetMapping
    public ResponseEntity<List<EssentialProductResponseDto>> getAllProducts() {
        List<EssentialProductResponseDto> products = essentialProductService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    // 특정 상품 조회
    @GetMapping("/{id}")
    public ResponseEntity<EssentialProductResponseDto> getProductById(@PathVariable Long id) {
        EssentialProductResponseDto product = essentialProductService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    // 새로운 상품 등록
    @PostMapping
    public ResponseEntity<EssentialProductResponseDto> createProduct(@RequestBody EssentialProductRegisterRequestDto requestDto) {
        EssentialProductResponseDto createdProduct = essentialProductService.save(requestDto);
        return ResponseEntity.ok(createdProduct);
    }

    // 상품 수정
    @PutMapping("/{id}")
    public ResponseEntity<EssentialProductResponseDto> updateProduct(@PathVariable Long id, @RequestBody EssentialProductRegisterRequestDto requestDto) {
        EssentialProductResponseDto updatedProduct = essentialProductService.updateProduct(id, requestDto);
        return ResponseEntity.ok(updatedProduct);
    }

    // 상품 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        essentialProductService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}

