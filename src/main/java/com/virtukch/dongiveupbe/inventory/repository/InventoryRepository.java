package com.virtukch.dongiveupbe.inventory.repository;

import com.virtukch.dongiveupbe.inventory.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
