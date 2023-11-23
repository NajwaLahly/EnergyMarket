package com.example.energymarket.domain.ports.in;

import com.example.energymarket.domain.pojo.Market;
import com.example.energymarket.domain.pojo.OfferBO;

import java.util.List;

public interface OfferServicePort {

    OfferBO add(OfferBO offerBO);
    List<OfferBO> findByMarket(Market market);
}
