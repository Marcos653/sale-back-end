package com.sale.view.model;

import java.util.ArrayList;
import java.util.List;

import com.sale.Model.Sale;

public class SellerResponse {
    
    private Long id;
    private String name;
    private List<Sale> sale = new ArrayList<>();

    
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
    public List<Sale> getSale() {
        return sale;
    }
    public void setSale(List<Sale> sale) {
        this.sale = sale;
    }

    
}
