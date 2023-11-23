package com.example.energymarket.persistence.repository;

import com.example.energymarket.domain.pojo.PlantBO;
import com.example.energymarket.domain.ports.out.PlantPersistencePort;
import com.example.energymarket.persistence.adapter.BOEntityMapper;
import com.example.energymarket.persistence.entity.Plant;
import org.springframework.stereotype.Repository;

@Repository
public class PlantRepository implements PlantPersistencePort {
    private final IPlantRepository plantRepository;
    private final BOEntityMapper boEntityMapper;

    public PlantRepository(IPlantRepository plantRepository, BOEntityMapper boEntityMapper) {
        this.plantRepository = plantRepository;
        this.boEntityMapper = boEntityMapper;
    }

    @Override
    public PlantBO add(PlantBO plantBO) {
        Plant savedPlant = boEntityMapper.toPlant(plantBO);
        return boEntityMapper.toPlantBO(plantRepository.save(savedPlant));
    }
}
