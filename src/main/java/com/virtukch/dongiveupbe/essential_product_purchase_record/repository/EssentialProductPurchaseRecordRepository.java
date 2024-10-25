package com.virtukch.dongiveupbe.essential_product_purchase_record.repository;

import com.virtukch.dongiveupbe.essential_product_purchase_record.entity.EssentialProductPurchaseRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EssentialProductPurchaseRecordRepository extends JpaRepository<EssentialProductPurchaseRecord, Long> {

    List<EssentialProductPurchaseRecord> findByGameMemberId(@Param("gameMemberId") Long gameMemberId);

}
