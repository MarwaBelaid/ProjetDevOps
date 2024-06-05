package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StockServiceImplTest {

    @Mock
    StockRepository stockRepository;


    @InjectMocks
    StockServiceImpl stockServiceImpl;

    Stock stock = new Stock("stock 1", 50, 20);
    List<Stock> listStocks = new ArrayList<Stock>() {
        {
            add(new Stock("stock 1", 50, 20));
            add(new Stock("stock 2", 120, 2));
            add(new Stock("stock 3", 40, 85));

        }
    };

    @Test
    public void testRetrieveUser() {
        Mockito.when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(stock))
        ;
        Stock Stock1 = stockServiceImpl.retrieveStock(2L);
        Assertions.assertNotNull(Stock1);
    }


}