package com.example.xbrain.service;

import com.example.xbrain.controller.SaleController;
import com.example.xbrain.entities.Sale;
import com.example.xbrain.entities.Seller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SaleServiceTest {


    @Autowired
    private SaleController saleController;

    @MockBean
    private SaleService saleService;

    @MockBean
    private SellerService sellerService;

    private Seller seller;
    private Sale sale1;
    private Sale sale2;
    private Sale sale3;

    @BeforeEach
    void setUp() {
        seller = new Seller(1L, "Lucas Bassetto");
        sale1 = new Sale(1L, Instant.now(), 100.0, seller);
        sale2 = new Sale(2L, Instant.now(), 200.0, seller);
        sale3 = new Sale(3L, Instant.now(), 300.0, seller);

        // configurando o mock para retornar as vendas que foram criadas acima
        List<Sale> sales = Arrays.asList(sale1, sale2, sale3);
        Mockito.when(saleService.findAll()).thenReturn(sales);
    }

    @Test
    void testFindAllBySeller() {

        // Given
        sellerService.findById(seller.getId());
        saleService.findById(1L);
        saleService.findById(2L);
        saleService.findById(3L);

        // When
        ResponseEntity<List<Sale>> response = saleController.findAll();

        // Then
        assertNotNull(response);
        assertEquals(3, response.getBody().size());

        Sale sale = response.getBody().get(0);
        assertNotNull(sale);
        assertEquals(sale1.getId(), sale.getId());
        assertEquals(sale1.getDate(), sale.getDate());
        assertEquals(sale1.getPrice(), sale.getPrice());
        assertEquals(sale1.getSeller().getId(), sale.getSeller().getId());

        sale = response.getBody().get(1);
        assertNotNull(sale);
        assertEquals(sale2.getId(), sale.getId());
        assertEquals(sale2.getDate(), sale.getDate());
        assertEquals(sale2.getPrice(), sale.getPrice());
        assertEquals(sale2.getSeller().getId(), sale.getSeller().getId());

        sale = response.getBody().get(2);
        assertNotNull(sale);
        assertEquals(sale3.getId(), sale.getId());
        assertEquals(sale3.getDate(), sale.getDate());
        assertEquals(sale3.getPrice(), sale.getPrice());
        assertEquals(sale3.getSeller().getId(), sale.getSeller().getId());
    }

}