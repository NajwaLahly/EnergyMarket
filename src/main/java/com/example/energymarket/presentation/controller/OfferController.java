package com.example.energymarket.presentation.controller;

import com.example.energymarket.domain.pojo.Market;
import com.example.energymarket.domain.pojo.OfferBO;
import com.example.energymarket.domain.ports.in.OfferServicePort;
import com.example.energymarket.presentation.adapter.BODtoMapper;
import com.example.energymarket.presentation.dto.OfferDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/offers")
public class OfferController {
    private final OfferServicePort offerService;
    private final BODtoMapper boDtoMapper;

    public OfferController(OfferServicePort offerService, BODtoMapper boDtoMapper) {
        this.offerService = offerService;
        this.boDtoMapper = boDtoMapper;
    }

    @PostMapping
    public ResponseEntity<OfferDto> add(@RequestBody OfferDto offerDto) {
        OfferBO postedOffer = boDtoMapper.toOfferBO(offerDto);
        offerService.add(postedOffer);
        return ResponseEntity.status(HttpStatus.CREATED).body(boDtoMapper.toOfferDto(postedOffer));
    }

    @GetMapping("/{market}")
    public ResponseEntity<List<OfferDto>> findByMarket(@PathVariable("market") Market market) {
        List<OfferDto> marketOffers = offerService.findByMarket(market)
                .stream()
                .map(offer -> boDtoMapper.toOfferDto(offer))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(marketOffers);
    }
}
