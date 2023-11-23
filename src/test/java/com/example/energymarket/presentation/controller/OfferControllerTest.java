package com.example.energymarket.presentation.controller;

import com.example.energymarket.domain.pojo.BlockBO;
import com.example.energymarket.domain.pojo.Market;
import com.example.energymarket.domain.pojo.OfferBO;
import com.example.energymarket.domain.ports.in.OfferServicePort;
import com.example.energymarket.presentation.adapter.BODtoMapper;
import com.example.energymarket.presentation.dto.BlockDto;
import com.example.energymarket.presentation.dto.OfferDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OfferController.class)
public class OfferControllerTest {
    @MockBean
    OfferServicePort offerService;
    @Autowired
    MockMvc mockMvc;
    @MockBean
    BODtoMapper boDtoMapper;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("Should create an offer with post request")
    void shouldAdd() throws Exception {
        //Arrange
        OfferBO offerBO = new OfferBO("offer-1", Market.PRIMARY, new ArrayList<BlockBO>());
        OfferDto offerDto = new OfferDto("offer-1", Market.PRIMARY, new ArrayList<BlockDto>());
        when(boDtoMapper.toOfferDto(offerBO)).thenReturn(offerDto);
        when(boDtoMapper.toOfferBO(offerDto)).thenReturn(offerBO);
        when(offerService.add(any(OfferBO.class))).thenReturn(offerBO);

        //Act
        mockMvc.perform(post("/offers")
                        .content(objectMapper.writeValueAsString(offerBO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                //Assert
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(offerDto), true));
        verify(offerService, times(1)).add(offerBO);
        verifyNoMoreInteractions(offerService);
    }

    @Test
    @DisplayName("should get offers that sell on market with get request")
    void shouldFindByMarket() throws Exception {
        //Arrange
        List<OfferBO> marketOffers = List.of(new OfferBO("offer-1", Market.PRIMARY, new ArrayList<BlockBO>()));
        List<OfferDto> marketOffersDto = List.of(new OfferDto("offer-1", Market.PRIMARY, new ArrayList<BlockDto>()));
        when(offerService.findByMarket(any(Market.class))).thenReturn(marketOffers);
        when(boDtoMapper.toOfferDto(any(OfferBO.class))).thenReturn(new OfferDto("offer-1", Market.PRIMARY, new ArrayList<BlockDto>()));
        when(boDtoMapper.toOfferBO(any(OfferDto.class))).thenReturn(new OfferBO("offer-1", Market.PRIMARY, new ArrayList<BlockBO>()));

        //Act
        mockMvc.perform(get("/offers/{market}", Market.PRIMARY))
                //Assert
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(marketOffersDto)));
        verify(offerService, times(1)).findByMarket(Market.PRIMARY);
        verifyNoMoreInteractions(offerService);
    }

}
