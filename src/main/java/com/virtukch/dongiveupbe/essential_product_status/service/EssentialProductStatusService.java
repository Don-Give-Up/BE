package com.virtukch.dongiveupbe.essential_product_status.service;

import com.virtukch.dongiveupbe.essential_product_status.dto.EssentialProductStatusRegisterRequestDto;
import com.virtukch.dongiveupbe.essential_product_status.dto.EssentialProductStatusResponseDto;
import com.virtukch.dongiveupbe.essential_product_status.entity.EssentialProductStatus;
import com.virtukch.dongiveupbe.essential_product_status.repository.EssentialProductStatusRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EssentialProductStatusService {
    private final EssentialProductStatusRepository essentialProductStatusRepository;

    public EssentialProductStatusService(EssentialProductStatusRepository essentialProductStatusRepository) {
        this.essentialProductStatusRepository = essentialProductStatusRepository;
    }

    @Transactional(readOnly = true)
    public EssentialProductStatus findById(Long essentialProductStatusId) {
        return essentialProductStatusRepository.findById(essentialProductStatusId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 EssentialProductStatus ID입니다: " + essentialProductStatusId));
    }

    @Transactional(readOnly = true)
    public List<EssentialProductStatusResponseDto> getProductStatusByRound(Long roundId) {
        return essentialProductStatusRepository.findByRoundId(roundId).stream()
                .map(EssentialProductStatusResponseDto::fromEntity)
                .toList();
    }

    @Transactional
    public EssentialProductStatusResponseDto save(EssentialProductStatusRegisterRequestDto requestDto) {
        EssentialProductStatus productStatus = requestDto.toEntity();
        EssentialProductStatus saved = essentialProductStatusRepository.save(productStatus);
        return EssentialProductStatusResponseDto.fromEntity(saved);
    }

    @Transactional
    public EssentialProductStatusResponseDto updateProductStatusAmount(Long statusId, Long amount) {
        EssentialProductStatus productStatus = essentialProductStatusRepository.findById(statusId)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 상품 상태를 찾을 수 없습니다. ID: " + statusId));
        productStatus = EssentialProductStatus.builder()
                .essentialProductStatusId(productStatus.getEssentialProductStatusId())
                .essentialProductId(productStatus.getEssentialProductId())
                .roundId(productStatus.getRoundId())
                .essentialProductStatusPrice(productStatus.getEssentialProductStatusPrice())
                .essentialProductAmount(amount)
                .build();

        EssentialProductStatus updatedStatus = essentialProductStatusRepository.save(productStatus);
        return EssentialProductStatusResponseDto.fromEntity(updatedStatus);
    }

    @Transactional(readOnly = true)
    public List<EssentialProductStatusResponseDto> getAllProductStatuses() {
        return essentialProductStatusRepository.findAll().stream()
                .map(EssentialProductStatusResponseDto::fromEntity)
                .toList();
    }

}
