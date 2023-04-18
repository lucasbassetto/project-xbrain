package com.example.xbrain.config;

import com.example.xbrain.entities.Sale;
import com.example.xbrain.entities.Seller;
import com.example.xbrain.repository.SaleRepository;
import com.example.xbrain.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public void run(String... args) throws Exception {

        Seller s1 = new Seller(null, "Lucas Bassetto");
        Seller s2 = new Seller(null, "Joao das neves");

        Sale sa1 = new Sale(null, Instant.parse("2023-02-12T20:32:11Z"), 2999.00, s1);
        Sale sa2 = new Sale(null, Instant.parse("2023-02-13T15:30:11Z"), 1500.00, s1);
        Sale sa3 = new Sale(null, Instant.parse("2023-02-14T20:32:11Z"), 1000.00, s1);
        Sale sa4 = new Sale(null, Instant.parse("2023-02-16T02:39:10Z"), 1000.00, s2);
        Sale sa5 = new Sale(null, Instant.parse("2023-02-19T12:12:22Z"), 500.00, s2);

        sellerRepository.saveAll(Arrays.asList(s1, s2));
        saleRepository.saveAll(Arrays.asList(sa1, sa2, sa3, sa4, sa5));
    }
}
