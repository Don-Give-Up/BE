package com.virtukch.dongiveupbe.saving_product_status.service;

import com.virtukch.dongiveupbe.saving_product_status.dto.SavingProductStatusRequestDto;
import com.virtukch.dongiveupbe.saving_product_status.dto.SavingProductStatusResponseDto;
import com.virtukch.dongiveupbe.saving_product_status.entity.SavingProductStatus;
import com.virtukch.dongiveupbe.saving_product_status.exception.SavingProductStatusNotFoundException;
import com.virtukch.dongiveupbe.saving_product_status.repository.SavingProductStatusRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavingProductStatusService {

    private final SavingProductStatusRepository savingProductStatusRepository;

    @Autowired
    public SavingProductStatusService(SavingProductStatusRepository savingProductStatusRepository) {
        this.savingProductStatusRepository = savingProductStatusRepository;
    }

    // 1. 저축 상품 전체 조회 (매 라운드에 세 개 씩 받아 볼 수 있음)
    public List<SavingProductStatusResponseDto> findAll() {
        return savingProductStatusRepository.findAll().stream()
            .map(SavingProductStatusResponseDto::fromEntity).toList();
    }

    // 2. 라운드 아이디에 따른 저축 상품 전체 조회 (3개)
    public List<SavingProductStatusResponseDto> findByRoundId(Long roundId) {
        return savingProductStatusRepository.findByRoundId(roundId).stream()
            .map(SavingProductStatusResponseDto::fromEntity).toList();
    }

    // 3. 저축 상품 아이디에 따른 저축 상품 전체 조회 (라운드 별 해당 저축 상품의 추이)
    public List<SavingProductStatusResponseDto> findBySavingProductId(Long savingProductId) {
        return savingProductStatusRepository.findBySavingProductId(savingProductId).stream()
            .map(SavingProductStatusResponseDto::fromEntity).toList();
    }

    // 4. 저축 상품 상태 아이디에 따른 저축 상품 단일 조회 (오직 1개)
    public SavingProductStatusResponseDto findById(Long savingProductStatusId) {
        return SavingProductStatusResponseDto.fromEntity(
            savingProductStatusRepository.findById(savingProductStatusId).orElseThrow(
                () -> new SavingProductStatusNotFoundException(
                    "해당 저축 상품 상태 아이디에 해당하는 저축 상품 상태가 존재하지 않습니다.")));
    }

    // 5. 저축 상품 추가
    public SavingProductStatusResponseDto save(
        SavingProductStatusRequestDto savingProductStatusRequestDto) {
        return SavingProductStatusResponseDto.fromEntity(savingProductStatusRepository.save(
            SavingProductStatusRequestDto.toEntity(savingProductStatusRequestDto)));
    }
}