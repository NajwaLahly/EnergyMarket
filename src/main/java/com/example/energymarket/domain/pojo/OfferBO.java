package com.example.energymarket.domain.pojo;

import java.util.List;

public record OfferBO(String name, Market market, List<BlockBO> blocks) {
}
