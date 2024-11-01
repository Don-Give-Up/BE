package com.virtukch.dongiveupbe.select_product.service;

import com.virtukch.dongiveupbe.essential_product.exception.EntityNotFoundException;
import com.virtukch.dongiveupbe.select_product.dto.SelectProductRequestDto;
import com.virtukch.dongiveupbe.select_product.dto.SelectProductResponseDto;
import com.virtukch.dongiveupbe.select_product.entity.SelectProduct;
import com.virtukch.dongiveupbe.select_product.repository.SelectProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class SelectProductService {
    private final SelectProductRepository selectProductRepository;

    public SelectProductService(SelectProductRepository selectProductRepository) {
        this.selectProductRepository = selectProductRepository;
    }

    // 저장
    public SelectProductResponseDto save(SelectProductRequestDto requestDto) {
        SelectProduct selectProduct = requestDto.toEntity();
        SelectProduct saved = selectProductRepository.save(selectProduct);
        return SelectProductResponseDto.fromEntity(saved);
    }

    // 전체 조회
    public List<SelectProductResponseDto> findAll() {
        return selectProductRepository.findAll().stream()
                .map(SelectProductResponseDto::fromEntity)
                .toList();
    }

    // id 값으로 조회
    public SelectProductResponseDto findById(Long id) {
        SelectProduct selectProduct = selectProductRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("선택 상품이 없습니다 ID: " + id));
        return SelectProductResponseDto.fromEntity(selectProduct);
    }

    // 수정
    public SelectProductResponseDto update(Long id, SelectProductRequestDto requestDto) {
        SelectProduct selectProduct = selectProductRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("선택 상품을 찾을 수 없습니다. ID: " + id));
        SelectProduct updateProduct = SelectProduct.builder()
                .selectProductId(selectProduct.getSelectProductId())
                .selectProductName(requestDto.getSelectProductName())
                .selectProductDescription(requestDto.getSelectProductDescription())
                .selectProductViewAmount(requestDto.getSelectProductViewAmount())
                .selectProductUrl(requestDto.getSelectProductUrl())
                .build();
        SelectProduct updated = selectProductRepository.save(updateProduct);
        return SelectProductResponseDto.fromEntity(updated);

    }
}
