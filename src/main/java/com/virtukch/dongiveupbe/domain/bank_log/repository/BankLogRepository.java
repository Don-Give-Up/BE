package com.virtukch.dongiveupbe.domain.bank_log.repository;

import com.virtukch.dongiveupbe.domain.bank_log.entity.BankLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankLogRepository extends JpaRepository<BankLog, Long> {
    List<BankLog> findByGameMemberId(Long gameMemberId);
}
