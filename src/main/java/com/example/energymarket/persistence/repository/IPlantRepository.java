package com.example.energymarket.persistence.repository;

import com.example.energymarket.persistence.entity.Plant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface IPlantRepository extends CrudRepository<Plant, UUID> {
}
