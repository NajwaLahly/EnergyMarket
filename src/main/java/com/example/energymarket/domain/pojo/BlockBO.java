package com.example.energymarket.domain.pojo;

import java.math.BigDecimal;
import java.util.Date;

public record BlockBO(PlantBO plant, BigDecimal price, long production, Date startTime, Date endTime) {
}
