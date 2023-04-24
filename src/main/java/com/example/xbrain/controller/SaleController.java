package com.example.xbrain.controller;

import com.example.xbrain.dto.SellerDTO;
import com.example.xbrain.entities.Sale;
import com.example.xbrain.service.SaleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;


@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService service;

    @GetMapping
    public ResponseEntity<List<Sale>> findAll() {
        List<Sale> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Sale> findById(@PathVariable Long id){
        Sale obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping(value = "/between")
    public ResponseEntity<List<SellerDTO>> findAllByDateBetween(@RequestParam Instant startDate, @RequestParam Instant endDate) {
        List<SellerDTO> list = service.findBetween(startDate, endDate);
        return ResponseEntity.ok().body(list);
    }




}


