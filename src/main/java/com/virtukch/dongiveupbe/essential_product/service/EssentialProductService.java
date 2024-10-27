package com.virtukch.dongiveupbe.essential_product.service;

import com.virtukch.dongiveupbe.essential_product.dto.EssentialProductRequestDto;
import com.virtukch.dongiveupbe.essential_product.dto.EssentialProductResponseDto;
import com.virtukch.dongiveupbe.essential_product.entity.EssentialProduct;
import com.virtukch.dongiveupbe.essential_product.exception.EntityNotFoundException;
import com.virtukch.dongiveupbe.essential_product.repository.EssentialProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EssentialProductService {
    private final EssentialProductRepository essentialProductRepository;

    public EssentialProductService(EssentialProductRepository essentialProductRepository) {
        this.essentialProductRepository = essentialProductRepository;
    }

    // 저장
    public EssentialProductResponseDto save(EssentialProductRequestDto requestDto) {
        EssentialProduct product = requestDto.toEntity();
        EssentialProduct saved = essentialProductRepository.save(product);
        return EssentialProductResponseDto.fromEntity(saved);
    }

    // 전체 조회
    public List<EssentialProductResponseDto> getAllProducts() {
        return essentialProductRepository.findAll().stream()
                .map(EssentialProductResponseDto::fromEntity)
                .toList();
    }

    // id 값으로 조회
    public EssentialProductResponseDto getProductById(long id) {
        EssentialProduct product = essentialProductRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("상품이 없습니다. ID: " + id));
        return EssentialProductResponseDto.fromEntity(product);
    }

    // 수정
    public EssentialProductResponseDto updateProduct(Long id, EssentialProductRequestDto requestDto) {
        EssentialProduct product = essentialProductRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("상품을 찾을 수 없습니다. ID: " + id));
        EssentialProduct updatedProduct = EssentialProduct.builder()
                .essentialProductId(product.getEssentialProductId())
                .essentialProductName(requestDto.getEssentialProductName())
                .essentialProductHp(requestDto.getEssentialProductHp())
                .essentialProductDescription(requestDto.getEssentialProductDescription())
                .build();
        EssentialProduct updated = essentialProductRepository.save(updatedProduct);
        return EssentialProductResponseDto.fromEntity(updated);
    }

    // 삭제
    public void deleteProduct(long id) {
        essentialProductRepository.deleteById(id);
    }
}
