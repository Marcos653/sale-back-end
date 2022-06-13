package com.sale.shared;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sale.Model.Seller;

public class SaleDTO {
    
    private Long id;
    private Double price;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate date = LocalDate.now();
    private Long seller_id;
    private String seller_name;

    private Seller seller;


    

    

    public String getSeller_name() {
        return seller_name;
    }

    public void setSeller_name(String seller_name) {
        this.seller_name = seller_name;
    }

    public Long getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(Long seller_id) {
        this.seller_id = seller_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getdate() {
        return date;
    }

    public void setdate(LocalDate date) {
        this.date = date;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }


    

}
