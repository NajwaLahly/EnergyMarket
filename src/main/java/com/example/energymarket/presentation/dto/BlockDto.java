package com.example.energymarket.presentation.dto;

import java.math.BigDecimal;
import java.util.Date;

public record BlockDto(PlantDto plant, BigDecimal price, long production, Date startTime, Date endTime) {
}
