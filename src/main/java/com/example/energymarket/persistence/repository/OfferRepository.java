package com.example.energymarket.persistence.repository;

import com.example.energymarket.domain.pojo.Market;
import com.example.energymarket.domain.pojo.OfferBO;
import com.example.energymarket.domain.pojo.PlantBO;
import com.example.energymarket.domain.ports.out.OfferPersistencePort;
import com.example.energymarket.persistence.adapter.BOEntityMapper;
import com.example.energymarket.persistence.entity.Offer;
import com.example.energymarket.persistence.entity.Plant;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OfferRepository implements OfferPersistencePort {
    private final IOfferRepository offerRepository;
    private final BOEntityMapper boEntityMapper;

    public OfferRepository(IOfferRepository offerRepository, BOEntityMapper boEntityMapper) {
        this.offerRepository = offerRepository;
        this.boEntityMapper = boEntityMapper;
    }

    @Override
    public OfferBO add(OfferBO offerBO) {
        Offer persistedOffer = boEntityMapper.toOffer(offerBO);
        return boEntityMapper.toOfferBO(offerRepository.save(persistedOffer));
    }

    @Override
    public List<OfferBO> findByMarket(Market market) {
        List<Offer> marketOffers = offerRepository.findByMarket(market);
        return marketOffers.stream().map(offer -> boEntityMapper.toOfferBO(offer)).collect(Collectors.toList());
    }

    @Override
    public List<PlantBO> findDistinctPlantsByMarket(Market market) {
        List<Plant> marketOffers = offerRepository.findDistinctPlantsByMarket(market);
        return marketOffers.stream().map(plant -> boEntityMapper.toPlantBO(plant)).collect(Collectors.toList());
    }
}
