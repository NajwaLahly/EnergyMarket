package com.example.energymarket.persistence.repository;

import com.example.energymarket.domain.pojo.Market;
import com.example.energymarket.persistence.entity.Offer;
import com.example.energymarket.persistence.entity.Plant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface IPlantRepository extends CrudRepository<Plant, UUID> {
    List<Offer> findByMarket(Market market);

    //TODO define query
    List<Plant> findDistinctPlantsByMarket(Market market);
}
