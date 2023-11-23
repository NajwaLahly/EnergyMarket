package com.example.energymarket.domain.service;

import com.example.energymarket.domain.pojo.Market;
import com.example.energymarket.domain.pojo.PlantBO;
import com.example.energymarket.domain.ports.in.PlantServicePort;

import java.util.List;

public class PlantService implements PlantServicePort {
    @Override
    public PlantBO add(PlantBO plantBO) {
        return null;
    }

    @Override
    public List<PlantBO> findByMarket(Market market) {
        return null;
    }
}
