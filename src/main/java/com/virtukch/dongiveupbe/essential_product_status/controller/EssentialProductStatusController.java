package com.virtukch.dongiveupbe.essential_product_status.controller;

import com.virtukch.dongiveupbe.essential_product_status.dto.EssentialProductStatusRegisterRequestDto;
import com.virtukch.dongiveupbe.essential_product_status.dto.EssentialProductStatusResponseDto;
import com.virtukch.dongiveupbe.essential_product_status.service.EssentialProductStatusService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/essential-product-status")
@Tag(name = "Essential Product Status API", description = "필수 상품 상태 관리를 위한 API")
public class EssentialProductStatusController {

    private final EssentialProductStatusService productStatusService;

    public EssentialProductStatusController(EssentialProductStatusService productStatusService) {
        this.productStatusService = productStatusService;
    }

    // 특정 라운드에 대한 모든 상품 상태 조회
    @GetMapping("/round/{roundId}")
    @Operation(summary = "특정 라운드의 상품 상태 조회", description = "특정 라운드의 모든 상품 상태를 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "상품 상태 조회 성공",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EssentialProductStatusResponseDto.class)))
    })
    public ResponseEntity<List<EssentialProductStatusResponseDto>> getProductStatusByRound(@PathVariable Long roundId) {
        List<EssentialProductStatusResponseDto> productStatusList = productStatusService.getProductStatusByRound(roundId);
        return ResponseEntity.ok(productStatusList);
    }

    // 상품 상태 생성
    @PostMapping
    @Operation(summary = "상품 상태 생성", description = "새로운 상품 상태를 생성합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "상품 상태 생성 성공",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EssentialProductStatusResponseDto.class)))
    })
    public ResponseEntity<EssentialProductStatusResponseDto> createProductStatus(
            @RequestBody EssentialProductStatusRegisterRequestDto requestDto) {
        EssentialProductStatusResponseDto createdProductStatus = productStatusService.save(requestDto);
        return ResponseEntity.ok(createdProductStatus);
    }

    // 상품 상태의 갯수 업데이트
    @PutMapping("/{statusId}/amount")
    @Operation(summary = "상품 상태의 갯수 업데이트", description = "특정 상품 상태의 갯수를 업데이트합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "상품 상태 갯수 업데이트 성공",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EssentialProductStatusResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "상품 상태를 찾을 수 없음")
    })
    public ResponseEntity<EssentialProductStatusResponseDto> updateProductStatusAmount(
            @PathVariable Long statusId,
            @RequestParam Long amount) {
        EssentialProductStatusResponseDto updatedProductStatus = productStatusService.updateProductStatusAmount(statusId, amount);
        return ResponseEntity.ok(updatedProductStatus);
    }

    @GetMapping
    @Operation(summary = "전체 상품 상태 조회", description = "모든 상품 상태 정보를 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "상품 상태 정보 조회 성공",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EssentialProductStatusResponseDto.class)))
    })
    public ResponseEntity<List<EssentialProductStatusResponseDto>> getAllProductStatuses() {
        List<EssentialProductStatusResponseDto> productStatuses = productStatusService.getAllProductStatuses();
        return ResponseEntity.ok(productStatuses);
    }

}
