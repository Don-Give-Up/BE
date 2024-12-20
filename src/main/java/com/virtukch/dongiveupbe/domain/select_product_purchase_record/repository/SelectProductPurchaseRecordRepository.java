package com.virtukch.dongiveupbe.domain.select_product_purchase_record.repository;

import com.virtukch.dongiveupbe.domain.select_product_purchase_record.dto.SelectProductPurchaseRecordResponseDto;
import com.virtukch.dongiveupbe.domain.select_product_purchase_record.entity.SelectProductPurchaseRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SelectProductPurchaseRecordRepository extends JpaRepository<SelectProductPurchaseRecord, Long> {

    @Query("SELECT new com.virtukch.dongiveupbe.domain.select_product_purchase_record.dto.SelectProductPurchaseRecordResponseDto(" +
            "r.gameId,r.selectProductPurchaseRecordId, p.selectProductName, r.gameMemberId, r.selectProductPurchaseAmount, " +
            "r.productTotalPrice) " +
            "FROM SelectProductPurchaseRecord r " +
            "JOIN SelectProduct p ON r.selectProductId = p.selectProductId " +
            "WHERE r.gameMemberId = :gameMemberId")
    List<SelectProductPurchaseRecordResponseDto> findPurchaseRecordsWithProductNameByGameMemberId(@Param("gameMemberId") Long gameMemberId);
}
