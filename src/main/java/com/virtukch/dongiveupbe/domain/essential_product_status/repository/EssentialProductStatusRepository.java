package com.virtukch.dongiveupbe.domain.essential_product_status.repository;

import com.virtukch.dongiveupbe.domain.essential_product_status.entity.EssentialProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EssentialProductStatusRepository extends JpaRepository<EssentialProductStatus, Long> {
    List<EssentialProductStatus> findByRoundId(Long roundId);

    List<EssentialProductStatus> findByEssentialProductIdAndRoundId(Long essentialProductId, Long roundId);
}
