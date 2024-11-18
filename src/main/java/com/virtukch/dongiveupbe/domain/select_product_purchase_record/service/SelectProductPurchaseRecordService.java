package com.virtukch.dongiveupbe.domain.select_product_purchase_record.service;

import com.virtukch.dongiveupbe.domain.select_product.dto.SelectProductResponseDto;
import com.virtukch.dongiveupbe.domain.select_product.entity.SelectProduct;
import com.virtukch.dongiveupbe.domain.select_product.service.SelectProductService;
import com.virtukch.dongiveupbe.domain.select_product_purchase_record.dto.SelectProductPurchaseRecordRequestDto;
import com.virtukch.dongiveupbe.domain.select_product_purchase_record.dto.SelectProductPurchaseRecordResponseDto;
import com.virtukch.dongiveupbe.domain.select_product_purchase_record.entity.SelectProductPurchaseRecord;
import com.virtukch.dongiveupbe.domain.select_product_purchase_record.exception.SpprNotFoundException;
import com.virtukch.dongiveupbe.domain.select_product_purchase_record.repository.SelectProductPurchaseRecordRepository;
import com.virtukch.dongiveupbe.domain.select_product.repository.SelectProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SelectProductPurchaseRecordService {

    private final SelectProductPurchaseRecordRepository purchaseRecordRepository;
    private final SelectProductService selectProductService;

    public SelectProductPurchaseRecordService(SelectProductPurchaseRecordRepository purchaseRecordRepository,
                                              SelectProductService selectProductService) {
        this.purchaseRecordRepository = purchaseRecordRepository;
        this.selectProductService = selectProductService;
    }

    @Transactional
    public SelectProductPurchaseRecordResponseDto save(SelectProductPurchaseRecordRequestDto requestDto) {
        // 상품 정보 가져오기
        SelectProductResponseDto product = selectProductService.findById(requestDto.getSelectProductId());
        // 총 가격 계산
        int totalPrice = product.getSelectProductPrice() * requestDto.getSelectProductPurchaseAmount().intValue();

        // 구매 기록 생성
        SelectProductPurchaseRecord purchaseRecord = SelectProductPurchaseRecord.builder()
                .selectProductId(product.getSelectProductId())
                .gameMemberId(requestDto.getGameMemberId())
                .selectProductPurchaseAmount(requestDto.getSelectProductPurchaseAmount())
                .productTotalPrice(totalPrice)
                .build();

        // 저장
        SelectProductPurchaseRecord savedRecord = purchaseRecordRepository.save(purchaseRecord);

        // DTO로 변환하여 반환
        return new SelectProductPurchaseRecordResponseDto(
                savedRecord.getSelectProductPurchaseRecordId(),
                product.getSelectProductName(),
                savedRecord.getGameMemberId(),
                savedRecord.getSelectProductPurchaseAmount(),
                savedRecord.getProductTotalPrice()
        );
    }

    @Transactional(readOnly = true)
    public List<SelectProductPurchaseRecordResponseDto> getPurchaseRecordsByGameMemberId(Long gameMemberId) {
        // 구매 기록과 상품명을 포함한 DTO를 반환
        return purchaseRecordRepository.findPurchaseRecordsWithProductNameByGameMemberId(gameMemberId);
    }
}
