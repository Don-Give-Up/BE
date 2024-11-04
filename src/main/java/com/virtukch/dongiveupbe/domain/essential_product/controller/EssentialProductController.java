package com.virtukch.dongiveupbe.domain.essential_product.controller;

import com.virtukch.dongiveupbe.domain.essential_product.dto.EssentialProductResponseDto;
import com.virtukch.dongiveupbe.domain.essential_product.service.EssentialProductService;
import com.virtukch.dongiveupbe.domain.essential_product.dto.EssentialProductRequestDto;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/essential-products")
@Tag(name = "필수 상품 API", description = "필수 상품 정보 관리를 위한 API")
public class EssentialProductController {

    private final EssentialProductService essentialProductService;

    public EssentialProductController(EssentialProductService essentialProductService) {
        this.essentialProductService = essentialProductService;
    }

    // 새로운 상품 등록
    @PostMapping
    @Operation(summary = "새로운 빵이 추가될 때 호출해 주세요. 빵의 가격과는 무관한 API 입니다.")
    public ResponseEntity<EssentialProductResponseDto> createProduct(
        @RequestBody EssentialProductRequestDto requestDto) {
        EssentialProductResponseDto createdProduct = essentialProductService.save(requestDto);
        return ResponseEntity.ok(createdProduct);
    }

    // 상품 수정
    @PutMapping("/{id}")
    @Operation(summary = "상품의 가격이 아닌 정보가 수정될 때 호출해 주세요. 빵의 가격과는 무관한 API 입니다.", description = "이름, 설명, 회복량 등이 바뀌지 않으면 호출할 필요 없습니다")
    public ResponseEntity<EssentialProductResponseDto> updateProduct(@PathVariable Long id,
        @RequestBody EssentialProductRequestDto requestDto) {
        EssentialProductResponseDto updatedProduct = essentialProductService.updateProduct(id,
            requestDto);
        return ResponseEntity.ok(updatedProduct);
    }

    // 상품 삭제
    @Hidden
    @DeleteMapping("/{id}")
    @Operation(summary = "상품 정보 삭제 ()", description = "ID를 통해 특정 필수 상품 정보를 삭제합니다.")
    @ApiResponse(responseCode = "204", description = "상품 삭제 성공")
    @ApiResponse(responseCode = "404", description = "상품을 찾을 수 없음")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        essentialProductService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    // 전체 상품 조회
    @Hidden
    @GetMapping
    @Operation(summary = "전체 상품 조회", description = "모든 필수 상품 정보를 조회합니다.")
    @ApiResponse(responseCode = "200", description = "상품 정보 조회 성공",
        content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = EssentialProductResponseDto.class)))
    public ResponseEntity<List<EssentialProductResponseDto>> getAllProducts() {
        List<EssentialProductResponseDto> products = essentialProductService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    // 특정 상품 조회
    @Hidden
    @GetMapping("/{id}")
    @Operation(summary = "특정 상품 조회", description = "ID를 통해 특정 필수 상품 정보를 조회합니다.")
    @ApiResponse(responseCode = "200", description = "상품 정보 조회 성공",
        content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = EssentialProductResponseDto.class)))
    @ApiResponse(responseCode = "404", description = "상품을 찾을 수 없음")
    public ResponseEntity<EssentialProductResponseDto> getProductById(@PathVariable Long id) {
        EssentialProductResponseDto product = essentialProductService.getProductById(id);
        return ResponseEntity.ok(product);
    }
}