package com.example.xbrain.service;

import com.example.xbrain.entities.Seller;
import com.example.xbrain.service.exception.DatabaseException;
import com.example.xbrain.service.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SellerServiceTest {

    @Autowired
    private SellerService service;

    @Test
    public void testFindAll() {
        List<Seller> list = service.findAll();
        assertNotNull(list);
        assertTrue(!list.isEmpty());
    }

    @Test
    public void testFindById() {
        Seller seller = service.findById(1L);
        assertNotNull(seller);
        assertEquals(1, seller.getId());
    }

    @Test
    public void testFindByIdNotFound() {
        assertThrows(ResourceNotFoundException.class, () -> {
            service.findById(999L);
        });
    }

    @Test
    public void testInsert() {
        Seller seller = new Seller(null, "Seller 4");
        seller = service.insert(seller);
        assertNotNull(seller.getId());
    }

    @Test
    public void testDelete() {
        service.delete(3L);
        assertThrows(ResourceNotFoundException.class, () -> {
            service.findById(3L);
        });
    }

    @Test
    public void testDeleteIntegrityViolation() {
        assertThrows(DatabaseException.class, () -> {
            service.delete(1L);
        });
    }
}