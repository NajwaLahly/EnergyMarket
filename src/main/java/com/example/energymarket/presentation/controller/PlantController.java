package com.example.energymarket.presentation.controller;

import com.example.energymarket.domain.pojo.Market;
import com.example.energymarket.domain.pojo.PlantBO;
import com.example.energymarket.domain.ports.in.PlantServicePort;
import com.example.energymarket.presentation.adapter.BODtoMapper;
import com.example.energymarket.presentation.dto.PlantDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/plants")
public class PlantController {
    private final PlantServicePort plantService;
    private final BODtoMapper boDtoMapper;

    public PlantController(PlantServicePort plantService, BODtoMapper boDtoMapper) {
        this.plantService = plantService;
        this.boDtoMapper = boDtoMapper;
    }

    @PostMapping
    public ResponseEntity<PlantDto> add(@RequestBody PlantDto plantDto) {
        PlantBO postedPlant = boDtoMapper.toPlantBO(plantDto);
        plantService.add(postedPlant);
        return ResponseEntity.status(HttpStatus.CREATED).body(boDtoMapper.toPlantDto(postedPlant));
    }

    @GetMapping
    public ResponseEntity<List<PlantDto>> findByMarket(@RequestParam("market") Market market) {
        List<PlantDto> marketPlants = plantService.findByMarket(market)
                .stream()
                .map(plant -> boDtoMapper.toPlantDto(plant))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(marketPlants);
    }
}
