package com.example.energymarket.persistence.repository;

import com.example.energymarket.domain.pojo.Market;
import com.example.energymarket.persistence.entity.Offer;
import com.example.energymarket.persistence.entity.Plant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface IOfferRepository extends CrudRepository<Offer, UUID> {
    List<Offer> findByMarket(Market market);
    @Query("SELECT DISTINCT b.plant FROM Offer o JOIN o.blocks b WHERE o.market = :market")
    List<Plant> findDistinctPlantsByMarket(Market market);
}
