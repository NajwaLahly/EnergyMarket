package com.example.energymarket.persistence.adapter;

import com.example.energymarket.domain.pojo.BlockBO;
import com.example.energymarket.domain.pojo.OfferBO;
import com.example.energymarket.domain.pojo.PlantBO;
import com.example.energymarket.persistence.entity.Block;
import com.example.energymarket.persistence.entity.Offer;
import com.example.energymarket.persistence.entity.Plant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BOEntityMapper {
    public Offer toOffer(OfferBO offerBO) {
        List<Block> blocks = offerBO.blocks().stream().map(block -> toBlock(block)).collect(Collectors.toList());
        return new Offer(offerBO.name(), offerBO.market(), blocks);
    }

    public OfferBO toOfferBO(Offer offer) {
        List<BlockBO> blocksBO = offer.getBlocks().stream().map(block -> toBlockBO(block)).collect(Collectors.toList());
        return new OfferBO(offer.getName(), offer.getMarket(), blocksBO);
    }

    public Block toBlock(BlockBO blockBO) {
        return new Block(toPlant(blockBO.plant()), blockBO.startTime(), blockBO.endTime(), blockBO.production(),
                blockBO.price());
    }

    public BlockBO toBlockBO(Block block) {
        return new BlockBO(toPlantBO(block.getPlant()), block.getPrice(), block.getProductionMW(), block.getStartTime(),
                block.getEndTime());
    }

    public Plant toPlant(PlantBO plantBO) {
        return new Plant(plantBO.type(), plantBO.name());
    }

    public PlantBO toPlantBO(Plant plant) {
        return new PlantBO(plant.getName(), plant.getType());
    }

}
