package com.example.energymarket.persistence.repository;

import com.example.energymarket.domain.pojo.PlantBO;
import com.example.energymarket.domain.ports.out.PlantPersistencePort;
import org.springframework.stereotype.Repository;

@Repository
public class PlantRepository implements PlantPersistencePort {

    @Override
    public PlantBO add(PlantBO plantBO) {
        return null;
    }
}
