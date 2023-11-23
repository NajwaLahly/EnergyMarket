package com.example.energymarket.domain.service;

import com.example.energymarket.domain.pojo.Market;
import com.example.energymarket.domain.pojo.OfferBO;
import com.example.energymarket.domain.ports.in.OfferServicePort;

import java.util.List;

public class OfferService implements OfferServicePort {
    @Override
    public OfferBO add(OfferBO offerBO) {
        return null;
    }

    @Override
    public List<OfferBO> findByMarket(Market market) {
        return null;
    }
}
