package com.virtukch.dongiveupbe.unit.repository;

import com.virtukch.dongiveupbe.unit.entity.Unit;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {

    Optional<Unit> findByUnitName(String unitName);
}