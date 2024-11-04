package com.virtukch.dongiveupbe.domain.select_product.controller;

import com.virtukch.dongiveupbe.domain.select_product.dto.SelectProductRequestDto;
import com.virtukch.dongiveupbe.domain.select_product.dto.SelectProductResponseDto;
import com.virtukch.dongiveupbe.domain.select_product.service.SelectProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "선택 상품 API", description = "선택 상품 정보 관리를 위한 API")
@RestController
@RequestMapping("/api/v1/select-products")
public class SelectProductController {

    private final SelectProductService selectProductService;

    public SelectProductController(SelectProductService selectProductService) {
        this.selectProductService = selectProductService;
    }

    // 선택 상품 생성
    @PostMapping
    @Operation(summary = "선택 상품 생성", description = "새로운 선택 상품 정보를 생성합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "상품 생성 성공",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = SelectProductResponseDto.class)))
    })
    public ResponseEntity<SelectProductResponseDto> saveSelectProduct(
        @RequestBody SelectProductRequestDto requestDto) {
        SelectProductResponseDto responseDto = selectProductService.save(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    // 전체 상품 조회
    @GetMapping
    @Operation(summary = "전체 선택 상품 조회", description = "모든 선택 상품 정보를 조회합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "상품 조회 성공",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = SelectProductResponseDto.class)))
    })
    public ResponseEntity<List<SelectProductResponseDto>> getAllSelectProducts() {
        List<SelectProductResponseDto> responseDtos = selectProductService.findAll();
        return ResponseEntity.ok(responseDtos);
    }

    // Id로 선택 상품 조회
    @GetMapping("/{id}")
    @Operation(summary = "ID로 선택 상품 조회", description = "ID를 통해 특정 선택 상품 정보를 조회합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "상품 조회 성공",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = SelectProductResponseDto.class))),
        @ApiResponse(responseCode = "404", description = "상품을 찾을 수 없음")
    })
    public ResponseEntity<SelectProductResponseDto> getSelectProductById(@PathVariable Long id) {
        SelectProductResponseDto responseDto = selectProductService.findById(id);
        return ResponseEntity.ok(responseDto);
    }

    // 선택 상품 수정
    @PutMapping("/{id}")
    @Operation(summary = "선택 상품 정보 수정", description = "ID를 통해 특정 선택 상품 정보를 수정합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "상품 수정 성공",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = SelectProductResponseDto.class))),
        @ApiResponse(responseCode = "404", description = "상품을 찾을 수 없음")
    })
    public ResponseEntity<SelectProductResponseDto> updateSelectProduct(@PathVariable Long id,
        @RequestBody SelectProductRequestDto requestDto) {
        SelectProductResponseDto responseDto = selectProductService.update(id, requestDto);
        return ResponseEntity.ok(responseDto);
    }
}