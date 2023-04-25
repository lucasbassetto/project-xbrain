package com.example.xbrain.service;

import com.example.xbrain.entities.Sale;
import com.example.xbrain.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    public List<Sale> findAll() {
        return repository.findAll();
    }

    public Sale findById(Long id) {
        Optional<Sale> obj = repository.findById(id);
        return obj.get();
    }

//    public List<SellerDTO> findBetween(@RequestParam Instant startDate, @RequestParam Instant endDate) {
//
//    }

    public List<Object[]> findDateBetween(Instant startDate, Instant endDate){
        return repository.findDateBetween(startDate,endDate);
    }
}
