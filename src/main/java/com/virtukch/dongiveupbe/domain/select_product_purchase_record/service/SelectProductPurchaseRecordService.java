package com.virtukch.dongiveupbe.domain.select_product_purchase_record.service;

import com.virtukch.dongiveupbe.domain.select_product.entity.SelectProduct;
import com.virtukch.dongiveupbe.domain.select_product_purchase_record.dto.SelectProductPurchaseRecordRequestDto;
import com.virtukch.dongiveupbe.domain.select_product_purchase_record.dto.SelectProductPurchaseRecordResponseDto;
import com.virtukch.dongiveupbe.domain.select_product_purchase_record.entity.SelectProductPurchaseRecord;
import com.virtukch.dongiveupbe.domain.select_product_purchase_record.exception.SpprNotFoundException;
import com.virtukch.dongiveupbe.domain.select_product_purchase_record.repository.SelectProductPurchaseRecordRepository;
import com.virtukch.dongiveupbe.domain.select_product.repository.SelectProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SelectProductPurchaseRecordService {

    private final SelectProductPurchaseRecordRepository purchaseRecordRepository;
    private final SelectProductRepository selectProductRepository;

    public SelectProductPurchaseRecordResponseDto save(SelectProductPurchaseRecordRequestDto requestDto) {
        SelectProductPurchaseRecord record = requestDto.toEntity();
        SelectProductPurchaseRecord savedRecord = purchaseRecordRepository.save(record);

        String selectProductName = selectProductRepository.findById(savedRecord.getSelectProductStatusId())
                .map(SelectProduct::getSelectProductName)
                .orElseThrow(() -> new SpprNotFoundException("상품을 찾을 수 없습니다."));

        return new SelectProductPurchaseRecordResponseDto(
                savedRecord.getSelectProductPurchaseRecordId(),
                selectProductName,
                savedRecord.getGameMemberId(),
                savedRecord.getSelectProductPurchaseAmount(),
                savedRecord.getTotalPrice()
        );
    }

    public List<SelectProductPurchaseRecordResponseDto> getPurchaseRecordsByStudent(Long gameMemberId) {
        return purchaseRecordRepository.findPurchaseRecordsWithProductNameByGameMemberId(gameMemberId);
    }
}
