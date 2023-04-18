package com.example.xbrain.controller;

import com.example.xbrain.entities.Seller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sellers")
public class SellerController {

    @GetMapping
    public ResponseEntity<Seller> findAll() {
        Seller s = new Seller(1L, "Lucas");
        return ResponseEntity.ok().body(s);
    }
}


