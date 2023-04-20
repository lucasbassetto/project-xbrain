package com.example.xbrain.dto;

public class SellerDTO
{
    private Long id;
    private String name;
    private Double dailyAverageQuantity;
    private Double dailyAverageAmount;
    private Double salesQuantity;

    public SellerDTO(){

    }
    public SellerDTO(Long id, String name, Double dailyAverageQuantity, Double dailyAverageAmount, Double salesQuantity)
    {
        this.id = id;
        this.name = name;
        this.dailyAverageQuantity = dailyAverageQuantity;
        this.dailyAverageAmount = dailyAverageAmount;
        this.salesQuantity = salesQuantity;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDailyAverageQuantity() {
        return dailyAverageQuantity;
    }

    public void setDailyAverageQuantity(Double dailyAverageQuantity) {
        this.dailyAverageQuantity = dailyAverageQuantity;
    }

    public Double getDailyAverageAmount() {
        return dailyAverageAmount;
    }

    public void setDailyAverageAmount(Double dailyAverageAmount) {
        this.dailyAverageAmount = dailyAverageAmount;
    }

    public Double getSalesQuantity() {
        return salesQuantity;
    }

    public void setSalesQuantity(Double salesQuantity) {
        this.salesQuantity = salesQuantity;
    }
}
