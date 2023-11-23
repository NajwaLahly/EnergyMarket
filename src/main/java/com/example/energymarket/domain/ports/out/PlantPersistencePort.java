package com.example.energymarket.domain.ports.out;

import com.example.energymarket.domain.pojo.PlantBO;

public interface PlantPersistencePort {
    PlantBO add(PlantBO plantBO);
}
