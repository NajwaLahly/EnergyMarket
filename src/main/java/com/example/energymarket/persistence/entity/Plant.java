package com.example.energymarket.persistence.entity;

import com.example.energymarket.domain.pojo.PlantType;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "plant")
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private PlantType type;
    private String name;

    public UUID getId() {
        return id;
    }

    public Plant(PlantType type, String name) {
        this.type = type;
        this.name = name;
    }

    public Plant() {
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public PlantType getType() {
        return type;
    }

    public void setType(PlantType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
