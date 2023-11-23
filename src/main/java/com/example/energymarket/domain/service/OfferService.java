package com.example.energymarket.domain.service;

import com.example.energymarket.domain.pojo.Market;
import com.example.energymarket.domain.pojo.OfferBO;
import com.example.energymarket.domain.ports.in.OfferServicePort;
import com.example.energymarket.domain.ports.out.OfferPersistencePort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService implements OfferServicePort {

    private final OfferPersistencePort offerPersistence;

    public OfferService(OfferPersistencePort offerPersistence) {
        this.offerPersistence = offerPersistence;
    }


    @Override
    public OfferBO add(OfferBO offerBO) {
        return offerPersistence.add(offerBO);
    }

    @Override
    public List<OfferBO> findByMarket(Market market) {
        return offerPersistence.findByMarket(market);
    }
}
