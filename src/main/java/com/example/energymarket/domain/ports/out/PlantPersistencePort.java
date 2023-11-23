package com.example.energymarket.domain.ports.out;

import com.example.energymarket.domain.pojo.Market;
import com.example.energymarket.domain.pojo.PlantBO;

import java.util.List;

public interface PlantPersistencePort {
    PlantBO add(PlantBO plantBO);
}
