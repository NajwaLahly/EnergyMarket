package com.example.energymarket.domain.ports.out;

import com.example.energymarket.domain.pojo.Market;
import com.example.energymarket.domain.pojo.OfferBO;
import com.example.energymarket.domain.pojo.PlantBO;

import java.util.List;

public interface OfferPersistencePort {
    OfferBO add(OfferBO offerBO);
    List<OfferBO> findByMarket(Market market);
    List<PlantBO> findDistinctPlantsByMarket(Market market);
}
