package com.virtukch.dongiveupbe.domain.saving_product.repository;

import com.virtukch.dongiveupbe.domain.saving_product.entity.SavingProduct;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingProductRepository extends JpaRepository <SavingProduct, Long> {

    Optional<SavingProduct> findBySavingProductName(String savingProductName);
}