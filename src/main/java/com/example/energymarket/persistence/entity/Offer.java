package com.example.energymarket.persistence.entity;

import com.example.energymarket.domain.pojo.Market;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Offer")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String name;
    Market market;
    @OneToMany(mappedBy = "offer")
    List<Block> blocks;

    public Offer(String name, Market market, List<Block> blocks) {
        this.name = name;
        this.market = market;
        this.blocks = blocks;
    }

    public Offer() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }
}
