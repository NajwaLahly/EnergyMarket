package com.example.energymarket.domain.ports.in;

import com.example.energymarket.domain.pojo.Market;
import com.example.energymarket.domain.pojo.PlantBO;

import java.util.List;

public interface PlantServicePort {

    PlantBO add(PlantBO plantBO);
    List<PlantBO> findByMarket(Market market);
}
