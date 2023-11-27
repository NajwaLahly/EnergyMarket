package com.example.energymarket.domain.service;


import com.example.energymarket.domain.pojo.BlockBO;
import com.example.energymarket.domain.pojo.Market;
import com.example.energymarket.domain.pojo.OfferBO;
import com.example.energymarket.domain.ports.out.OfferPersistencePort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
public class OfferServiceTest {

    @InjectMocks
    OfferService offerService;

    @Mock
    OfferPersistencePort offerRepository;

    @Test
    @DisplayName("should call repository to add an offer")
    void shouldAdd() {
        //Arrange
        OfferBO offer = new OfferBO("offer-1", Market.PRIMARY, new ArrayList<BlockBO>());
        when(offerRepository.add(offer)).thenReturn(offer);

        //Act
        offerService.add(offer);

        //Assert
        verify(offerRepository, times(1)).add(offer);
        verifyNoMoreInteractions(offerRepository);
    }

    @Test
    @DisplayName("should find offers by market")
    void shouldFindByMarket() {
        //Arrange
        List<OfferBO> primaryMarketOffers = List.of(new OfferBO("offer-1", Market.PRIMARY, new ArrayList<BlockBO>()));
        when(offerRepository.findByMarket(Market.PRIMARY)).thenReturn(primaryMarketOffers);

        //Act
        List<OfferBO> foundOffers = offerService.findByMarket(Market.PRIMARY);

        //Assert
        assertEquals(primaryMarketOffers, foundOffers);
        verify(offerRepository, times(1)).findByMarket(Market.PRIMARY);
        verifyNoMoreInteractions(offerRepository);
    }

}
