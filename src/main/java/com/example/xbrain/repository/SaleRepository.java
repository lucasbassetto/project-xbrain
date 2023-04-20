package com.example.xbrain.repository;

import com.example.xbrain.entities.Sale;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    List<Sale> findAllByDateBetween(Instant startDate, Instant endDate);

}