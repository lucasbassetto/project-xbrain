package com.example.xbrain.service;

import com.example.xbrain.entities.Sale;
import com.example.xbrain.entities.Seller;
import com.example.xbrain.repository.SaleRepository;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class SaleServiceTest {

    @InjectMocks
    SaleService saleService;

    @Mock
    SaleRepository saleRepository;

    @Test
    public void testarEAdicionarVenda() {
        Long id = 1L;
        Instant date = Instant.parse("2023-02-17T22:30:26-03:00");
        Double price = 1000.00;
        Seller seller = new Seller(1L, "Lucas Bassetto");

        Sale sale = new Sale(id, date, price, seller);

        Mockito.when(
                saleRepository.save(Mockito.any())
        ).thenReturn(sale);

        Sale vendaCriada = saleService.insert(sale);
        Assertions.assertEquals(id, vendaCriada.getId());
        Assertions.assertEquals(date, vendaCriada.getDate());
        Assertions.assertEquals(price, vendaCriada.getPrice());
        Assertions.assertEquals(seller, vendaCriada.getSeller());
    }
}