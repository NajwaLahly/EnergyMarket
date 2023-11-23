package com.example.energymarket.presentation.controller;

import com.example.energymarket.domain.pojo.Market;
import com.example.energymarket.domain.pojo.PlantBO;
import com.example.energymarket.domain.pojo.PlantType;
import com.example.energymarket.domain.ports.in.PlantServicePort;
import com.example.energymarket.presentation.adapter.BODtoMapper;
import com.example.energymarket.presentation.dto.PlantDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PlantController.class)
public class PlantControllerTest {
    @MockBean
    PlantServicePort plantService;
    @Autowired
    MockMvc mockMvc;
    @MockBean
    BODtoMapper boDtoMapper;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("Should create a plant with post request")
    void shouldAdd() throws Exception {
        //Arrange
        PlantBO plantBO = new PlantBO("plant-1", PlantType.SOLAR);
        PlantDto plantDto = new PlantDto("plant-1", PlantType.SOLAR);
        when(boDtoMapper.toPlantDto(plantBO)).thenReturn(plantDto);
        when(boDtoMapper.toPlantBO(plantDto)).thenReturn(plantBO);
        when(plantService.add(any(PlantBO.class))).thenReturn(plantBO);

        //Act
        mockMvc.perform(post("/plants")
                        .content(objectMapper.writeValueAsString(plantBO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                //Assert
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(plantDto), true));
        verify(plantService, times(1)).add(plantBO);
        verifyNoMoreInteractions(plantService);
    }

    @Test
    @DisplayName("should get plants that sell on market with get request")
    void shouldFindByMarket() throws Exception {
        //Arrange
        List<PlantBO> marketPlants = List.of(new PlantBO("plant-1", PlantType.SOLAR));
        List<PlantDto> marketPlantsDto = List.of(new PlantDto("plant-1", PlantType.SOLAR));
        when(plantService.findByMarket(Market.PRIMARY)).thenReturn(marketPlants);
        when(boDtoMapper.toPlantDto(any(PlantBO.class))).thenReturn(new PlantDto("plant-1", PlantType.SOLAR));
        when(boDtoMapper.toPlantBO(any(PlantDto.class))).thenReturn(new PlantBO("plant-1", PlantType.SOLAR));

        //Act
        mockMvc.perform(get("/plants/{market}", Market.PRIMARY))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(marketPlantsDto)));

        //Assert
        verify(plantService, times(1)).findByMarket(Market.PRIMARY);
        verifyNoMoreInteractions(plantService);
    }

}
