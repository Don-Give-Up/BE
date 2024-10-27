package com.virtukch.dongiveupbe.saving_product.service;

import com.virtukch.dongiveupbe.saving_product.entity.SavingProduct;
import com.virtukch.dongiveupbe.saving_product.exception.SavingProductNotFoundException;
import com.virtukch.dongiveupbe.saving_product.repository.SavingProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavingProductService {

    private final SavingProductRepository savingProductRepository;

    @Autowired
    public SavingProductService(SavingProductRepository savingProductRepository) {
        this.savingProductRepository = savingProductRepository;
    }

    // 1. 저축 상품 전체 조회
    public List<SavingProduct> findAll() {
        return savingProductRepository.findAll();
    }

    // 2. 저축 상품 이름으로 조회
    public SavingProduct findBySavingProductName(String savingProductName) {
        return savingProductRepository.findBySavingProductName(savingProductName)
            .orElseThrow(() -> new SavingProductNotFoundException("해당하는 저축 상품을 찾을 수 없습니다."));
    }

    // 3. 저축 상품 아이디로 조회
    public SavingProduct findById(Long savingProductId) {
        return savingProductRepository.findById(savingProductId).orElseThrow(
            () -> new SavingProductNotFoundException("해당하는 아이디와 일치하는 저축 상품을 찾을 수 없습니다."));
    }
}