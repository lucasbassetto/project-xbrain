package com.example.xbrain.config;

import com.example.xbrain.entities.Seller;
import com.example.xbrain.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private SellerRepository sellerRepository;


    @Override
    public void run(String... args) throws Exception {

        Seller s1 = new Seller(null, "Lucas Bassetto");
        Seller s2 = new Seller(null, "Joao das neves");

        sellerRepository.saveAll(Arrays.asList(s1, s2));
    }
}
