package com.virtukch.dongiveupbe.domain.inventory.repository;

import com.virtukch.dongiveupbe.domain.inventory.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
