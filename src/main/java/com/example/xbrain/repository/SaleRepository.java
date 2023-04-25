package com.example.xbrain.repository;

import com.example.xbrain.entities.Sale;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.Instant;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

//    List<Sale> findAllByDateBetween(Instant startDate, Instant endDate);

    @Query(value = "SELECT TB_SELLER.NAME, " +
            "COUNT(*) AS TOTAL_SALES, " +
            "COUNT(*) / DATEDIFF(DAY, :startDate, :endDate) AS AVG_DAILY_SALES " +
            "FROM TB_SALE " +
            "INNER JOIN TB_SELLER ON TB_SALE.SELLER_ID = TB_SELLER.ID " +
            "WHERE TB_SALE.DATE >= :startDate AND TB_SALE.DATE <= :endDate " +
            "GROUP BY TB_SELLER.NAME", nativeQuery = true)
    List<Object[]> findDateBetween(@Param("startDate") Instant startDate, @Param("endDate") Instant endDate);
}