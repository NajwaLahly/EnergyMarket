package com.example.energymarket.persistence.repository;

import com.example.energymarket.domain.pojo.Market;
import com.example.energymarket.domain.pojo.OfferBO;
import com.example.energymarket.domain.pojo.PlantBO;
import com.example.energymarket.domain.ports.out.OfferPersistencePort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OfferRepository implements OfferPersistencePort {
    @Override
    public OfferBO add(OfferBO offerBO) {
        return null;
    }

    @Override
    public List<OfferBO> findByMarket(Market market) {
        return null;
    }

    @Override
    public List<PlantBO> findDistinctPlantsByMarket(Market market) {
        return null;
    }
}
