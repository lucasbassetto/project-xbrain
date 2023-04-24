package com.example.xbrain.service;

import com.example.xbrain.dto.SellerDTO;
import com.example.xbrain.entities.Sale;
import com.example.xbrain.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
//        long days = Duration.between(startDate,endDate).toDays();
//    }
}
