package com.virtukch.dongiveupbe.select_product.controller;

import com.virtukch.dongiveupbe.select_product.dto.SelectProductRequestDto;
import com.virtukch.dongiveupbe.select_product.dto.SelectProductResponseDto;
import com.virtukch.dongiveupbe.select_product.service.SelectProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/select-products")
public class SelectProductController {

    private final SelectProductService selectProductService;

    public SelectProductController(SelectProductService selectProductService) {
        this.selectProductService = selectProductService;
    }

    // 전체 조회
    @GetMapping
    public ResponseEntity<List<SelectProductResponseDto>> getAllProducts() {
        List<SelectProductResponseDto> products = selectProductService.findAll();
        return ResponseEntity.ok(products);
    }

    // id로 조회
    @GetMapping("/{id}")
    public ResponseEntity<SelectProductResponseDto> getProductById(@PathVariable Long id) {
        SelectProductResponseDto product = selectProductService.findById(id);
        return ResponseEntity.ok(product);
    }

    // 저장
    @PostMapping
    public ResponseEntity<SelectProductResponseDto> createProduct(@RequestBody SelectProductRequestDto requestDto) {
        SelectProductResponseDto savedProduct = selectProductService.save(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    // 수정
    @PutMapping("/{id}")
    public ResponseEntity<SelectProductResponseDto> updateProduct(
            @PathVariable Long id,
            @RequestBody SelectProductRequestDto requestDto) {
        SelectProductResponseDto updatedProduct = selectProductService.update(id, requestDto);
        return ResponseEntity.ok(updatedProduct);
    }
}
