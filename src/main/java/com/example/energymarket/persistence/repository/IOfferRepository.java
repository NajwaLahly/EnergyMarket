package com.example.energymarket.persistence.repository;

import com.example.energymarket.persistence.entity.Offer;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface IOfferRepository extends CrudRepository<Offer, UUID> {
}
