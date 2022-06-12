package com.sale.view.model;

import javax.validation.constraints.NotNull;

import com.sale.Model.Seller;

public class SaleRequest {

    @NotNull
    private Double price;
    @NotNull
    private Seller seller;


    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Seller getSeller() {
        return seller;
    }
    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    
}
