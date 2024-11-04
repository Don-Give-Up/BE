package com.virtukch.dongiveupbe.domain.select_product.repository;

import com.virtukch.dongiveupbe.domain.select_product.entity.SelectProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SelectProductRepository extends JpaRepository<SelectProduct, Long> {
}