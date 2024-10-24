package com.virtukch.dongiveupbe.essential_product_purchase_record.repository;

import com.virtukch.dongiveupbe.essential_product_purchase_record.entity.EssentialProductPurchaseRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EssentialProductPurchaseRecordRepository extends JpaRepository<EssentialProductPurchaseRecord, Long> {

    @Query("SELECT e FROM EssentialProductPurchaseRecord e WHERE e.gameMemberId = :gameMemberId")
    List<EssentialProductPurchaseRecord> findByGameMemberId(@Param("gameMemberId") Long gameMemberId);

    @Query("SELECT e FROM EssentialProductPurchaseRecord e WHERE e.essentialProductStatusId = :essentialProductStatusId AND e.gameMemberId = :gameMemberId")
    List<EssentialProductPurchaseRecord> findByEssentialProductStatusIdAndGameMemberId(
            @Param("essentialProductStatusId") Long essentialProductStatusId,
            @Param("gameMemberId") Long gameMemberId);
}
