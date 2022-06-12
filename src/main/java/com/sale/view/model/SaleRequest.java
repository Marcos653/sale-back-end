package com.sale.view.model;

import javax.validation.constraints.NotNull;


public class SaleRequest {

    @NotNull
    private Double price;
    @NotNull
    private Long seller_id;
    


    public Long getSeller_id() {
        return seller_id;
    }
    public void setSeller_id(Long seller_id) {
        this.seller_id = seller_id;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    
}
