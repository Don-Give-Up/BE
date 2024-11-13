package com.virtukch.dongiveupbe.domain.bank_log.repository;

import com.virtukch.dongiveupbe.domain.bank_log.dto.BankLogResponseDto;
import com.virtukch.dongiveupbe.domain.bank_log.entity.BankLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BankLogRepository extends JpaRepository<BankLog, Long> {

    @Query("SELECT new com.virtukch.dongiveupbe.domain.bank_log.dto.BankLogResponseDto(b.bankLogId, b.gameMemberId, sp.savingProductName, b.bankTotalPrice) " +
            "FROM BankLog b JOIN com.virtukch.dongiveupbe.domain.saving_product.entity.SavingProduct sp " +
            "ON b.savingProductStatusId = sp.savingProductId WHERE b.gameMemberId = :gameMemberId")
    List<BankLogResponseDto> findBankLogsWithProductNameByGameMemberId(@Param("gameMemberId") Long gameMemberId);

    @Query("SELECT new com.virtukch.dongiveupbe.domain.bank_log.dto.BankLogResponseDto(" +
            "b.bankLogId, b.gameMemberId, sp.savingProductName) " +
            "FROM BankLog b " +
            "JOIN com.virtukch.dongiveupbe.domain.saving_product.entity.SavingProduct sp ON b.savingProductStatusId = sp.savingProductId")
    List<BankLogResponseDto> findAllBankLogsWithProductName();

    @Query("SELECT new com.virtukch.dongiveupbe.domain.bank_log.dto.BankLogResponseDto(" +
            "b.bankLogId, b.gameMemberId, sp.savingProductName) " +
            "FROM BankLog b " +
            "JOIN com.virtukch.dongiveupbe.domain.saving_product.entity.SavingProduct sp ON b.savingProductStatusId = sp.savingProductId " +
            "WHERE b.bankLogId = :bankLogId")
    Optional<BankLogResponseDto> findResponseDtoByBankLogId(@Param("bankLogId") Long bankLogId);

}
