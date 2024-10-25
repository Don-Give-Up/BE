package com.virtukch.dongiveupbe.essential_product.controller;

import com.virtukch.dongiveupbe.essential_product.dto.EssentialProductResponseDto;
import com.virtukch.dongiveupbe.essential_product.service.EssentialProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.virtukch.dongiveupbe.essential_product.dto.EssentialProductRegisterRequestDto;


@RestController
@RequestMapping("/api/v1/essential-products")
@Tag(name = "Essential Product API", description = "필수 상품 정보 관리를 위한 API")
public class EssentialProductController {

    private final EssentialProductService essentialProductService;

    public EssentialProductController(EssentialProductService essentialProductService) {
        this.essentialProductService = essentialProductService;
    }

    // 전체 상품 조회
    @GetMapping
    @Operation(summary = "전체 상품 조회", description = "모든 필수 상품 정보를 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "상품 정보 조회 성공",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EssentialProductResponseDto.class)))
    })
    public ResponseEntity<List<EssentialProductResponseDto>> getAllProducts() {
        List<EssentialProductResponseDto> products = essentialProductService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    // 특정 상품 조회
    @GetMapping("/{id}")
    @Operation(summary = "특정 상품 조회", description = "ID를 통해 특정 필수 상품 정보를 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "상품 정보 조회 성공",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EssentialProductResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "상품을 찾을 수 없음")
    })
    public ResponseEntity<EssentialProductResponseDto> getProductById(@PathVariable Long id) {
        EssentialProductResponseDto product = essentialProductService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    // 새로운 상품 등록
    @PostMapping
    @Operation(summary = "새로운 상품 등록", description = "새로운 필수 상품 정보를 등록합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "상품 등록 성공",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EssentialProductResponseDto.class)))
    })
    public ResponseEntity<EssentialProductResponseDto> createProduct(@RequestBody EssentialProductRegisterRequestDto requestDto) {
        EssentialProductResponseDto createdProduct = essentialProductService.save(requestDto);
        return ResponseEntity.ok(createdProduct);
    }

    // 상품 수정
    @PutMapping("/{id}")
    @Operation(summary = "상품 정보 수정", description = "ID를 통해 특정 필수 상품 정보를 수정합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "상품 수정 성공",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EssentialProductResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "상품을 찾을 수 없음")
    })
    public ResponseEntity<EssentialProductResponseDto> updateProduct(@PathVariable Long id, @RequestBody EssentialProductRegisterRequestDto requestDto) {
        EssentialProductResponseDto updatedProduct = essentialProductService.updateProduct(id, requestDto);
        return ResponseEntity.ok(updatedProduct);
    }

    // 상품 삭제
    @DeleteMapping("/{id}")
    @Operation(summary = "상품 정보 삭제", description = "ID를 통해 특정 필수 상품 정보를 삭제합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "상품 삭제 성공"),
            @ApiResponse(responseCode = "404", description = "상품을 찾을 수 없음")
    })
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        essentialProductService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}

