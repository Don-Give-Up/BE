package com.virtukch.dongiveupbe.unit.dataloader;

import com.virtukch.dongiveupbe.unit.entity.Unit;
import com.virtukch.dongiveupbe.unit.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UnitDataLoader implements CommandLineRunner {

    private final UnitRepository unitRepository;

    @Autowired
    public UnitDataLoader(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Unit unit1 = Unit.builder()
            .unitName("단원명 1")
            .build();
        unitRepository.save(unit1);

        Unit unit2 = Unit.builder()
            .unitName("단원명 2")
            .build();
        unitRepository.save(unit2);

        Unit unit3 = Unit.builder()
            .unitName("단원명 3")
            .build();
        unitRepository.save(unit3);

        Unit unit4 = Unit.builder()
            .unitName("단원명 4")
            .build();
        unitRepository.save(unit4);

        Unit unit5 = Unit.builder()
            .unitName("단원명 5")
            .build();
        unitRepository.save(unit5);
    }
}
