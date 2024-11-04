package com.virtukch.dongiveupbe.domain.saving_product_status.repository;

import com.virtukch.dongiveupbe.domain.saving_product_status.entity.SavingProductStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingProductStatusRepository extends JpaRepository<SavingProductStatus, Long> {

    List<SavingProductStatus> findByRoundId(Long roundId);

    List<SavingProductStatus> findBySavingProductId(Long savingProductId);
}