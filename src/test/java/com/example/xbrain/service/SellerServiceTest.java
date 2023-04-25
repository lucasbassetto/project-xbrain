package com.example.xbrain.service;

import com.example.xbrain.entities.Sale;
import com.example.xbrain.entities.Seller;
import com.example.xbrain.repository.SellerRepository;
import com.example.xbrain.service.exception.DatabaseException;
import com.example.xbrain.service.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SellerServiceTest {

    @InjectMocks
    SellerService service;

    @Mock
    SellerRepository repository;
    @Test
    public void testarEAdicionarVendedor() {
        Long id = 1L;
        String name = "Lucas Bassetto";

        Seller seller = new Seller(id, name);

        Mockito.when(
                repository.save(Mockito.any())
        ).thenReturn(seller);

        Seller sellerCriado = service.insert(seller);
        Assertions.assertEquals(id, sellerCriado.getId());
        Assertions.assertEquals(name, sellerCriado.getName());
    }

}