package com.example.energymarket.presentation.adapter;

import com.example.energymarket.domain.pojo.BlockBO;
import com.example.energymarket.domain.pojo.OfferBO;
import com.example.energymarket.domain.pojo.PlantBO;
import com.example.energymarket.presentation.dto.BlockDto;
import com.example.energymarket.presentation.dto.OfferDto;
import com.example.energymarket.presentation.dto.PlantDto;

import java.util.List;
import java.util.stream.Collectors;

public class BODtoMapper {
    public OfferBO toOfferBO(OfferDto offerDto) {
        List<BlockBO> blocksBO = offerDto.blocks().stream().map(block -> toBlockBO(block)).collect(Collectors.toList());
        return new OfferBO(offerDto.name(), offerDto.market(), blocksBO);
    }

    public OfferDto toOfferDto(OfferBO offerBO) {
        List<BlockDto> blocksDto = offerBO.blocks().stream().map(block -> toBlockDto(block)).collect(Collectors.toList());
        return new OfferDto(offerBO.name(), offerBO.market(), blocksDto);
    }

    public PlantBO toPlantBO(PlantDto plantDto) {
        return new PlantBO(plantDto.name(), plantDto.type());
    }

    public PlantDto toPlantDto(PlantBO plantBo) {
        return new PlantDto(plantBo.name(), plantBo.type());
    }

    public BlockBO toBlockBO(BlockDto blockDto) {
        return new BlockBO(toPlantBO(blockDto.plant()), blockDto.price(), blockDto.production(), blockDto.startTime(), blockDto.endTime());
    }

    public BlockDto toBlockDto(BlockBO blockBO) {
        return new BlockDto(toPlantDto(blockBO.plant()), blockBO.price(), blockBO.production(), blockBO.startTime(), blockBO.endTime());
    }
}
