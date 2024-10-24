package com.virtukch.dongiveupbe.stock_status.repository;

import com.virtukch.dongiveupbe.stock_status.entity.StockStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StockStatusRepository extends JpaRepository<StockStatus, Long> {

}