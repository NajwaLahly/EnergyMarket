package com.example.energymarket.persistence.entity;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@EntityScan
@Table(name = "Block")
public class Block {
    @Id
    @GeneratedValue
    private UUID blockId;
    @ManyToOne
    @JoinColumn(name = "plant_id")
    private Plant plant;
    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;
    private Date startTime;
    private Date endTime;
    private long productionMW;
    private BigDecimal price;

    public UUID getBlockId() {
        return blockId;
    }

    public void setBlockId(UUID blockId) {
        this.blockId = blockId;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public long getProductionMW() {
        return productionMW;
    }

    public void setProductionMW(long productionMW) {
        this.productionMW = productionMW;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
