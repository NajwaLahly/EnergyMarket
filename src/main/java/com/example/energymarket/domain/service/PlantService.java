package com.example.energymarket.domain.service;

import com.example.energymarket.domain.pojo.Market;
import com.example.energymarket.domain.pojo.PlantBO;
import com.example.energymarket.domain.ports.in.PlantServicePort;
import com.example.energymarket.domain.ports.out.OfferPersistencePort;
import com.example.energymarket.domain.ports.out.PlantPersistencePort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantService implements PlantServicePort {
    private final PlantPersistencePort plantPersistence;
    private final OfferPersistencePort offerPersistence;

    public PlantService(PlantPersistencePort plantPersistence, OfferPersistencePort offerPersistence) {
        this.plantPersistence = plantPersistence;
        this.offerPersistence = offerPersistence;
    }

    @Override
    public PlantBO add(PlantBO plantBO) {
        return plantPersistence.add(plantBO);
    }

    @Override
    public List<PlantBO> findByMarket(Market market) {
        return offerPersistence.findDistinctPlantsByMarket(market);
    }
}
