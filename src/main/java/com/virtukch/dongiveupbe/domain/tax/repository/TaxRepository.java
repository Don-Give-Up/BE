package com.virtukch.dongiveupbe.domain.tax.repository;

import com.virtukch.dongiveupbe.domain.tax.entity.Tax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxRepository extends JpaRepository<Tax, Long> {
}
