package com.example.energymarket.domain.service;

import com.example.energymarket.domain.pojo.Market;
import com.example.energymarket.domain.pojo.PlantBO;
import com.example.energymarket.domain.pojo.PlantType;
import com.example.energymarket.domain.ports.out.OfferPersistencePort;
import com.example.energymarket.domain.ports.out.PlantPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
public class PlantServiceTest {

    @InjectMocks
    PlantService plantService;

    @Mock
    PlantPersistencePort plantRepository;

    @Mock
    OfferPersistencePort offerRepository;


    @Test
    @DisplayName("should call repository to add new plant")
    void shouldAdd() {
        //Arrange
        PlantBO plant = new PlantBO("plant-1", PlantType.SOLAR);
        when(plantRepository.add(plant)).thenReturn(plant);

        //Act
        plantService.add(plant);

        //Assert
        verify(plantRepository, times(1)).add(plant);
        verifyNoMoreInteractions(plantRepository);
    }

    @Test
    @DisplayName("should call repository to get all plants that sell in a market")
    void shouldFindByMarket() {
        //Arrange
        PlantService plantService = new PlantService(plantRepository, offerRepository);
        List<PlantBO> primaryMarketPlants = List.of(new PlantBO("plant-1", PlantType.SOLAR));
        when(offerRepository.findDistinctPlantsByMarket(Market.PRIMARY)).thenReturn(primaryMarketPlants);

        //Act
        List<PlantBO> foundPlants = plantService.findByMarket(Market.PRIMARY);

        //Assert
        assertEquals(primaryMarketPlants, foundPlants);
        verify(offerRepository, times(1)).findDistinctPlantsByMarket(Market.PRIMARY);
        verifyNoMoreInteractions(offerRepository);
    }
}
