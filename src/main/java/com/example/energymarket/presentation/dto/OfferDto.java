package com.example.energymarket.presentation.dto;

import com.example.energymarket.domain.pojo.Market;

import java.util.List;

public record OfferDto(String name, Market market, List<BlockDto> blocks) {
}
