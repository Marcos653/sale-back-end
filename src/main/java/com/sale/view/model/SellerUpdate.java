package com.sale.view.model;

import java.util.ArrayList;
import java.util.List;

import com.sale.Model.Sale;

public class SellerUpdate {

    private String name;
    private List<Sale> sale = new ArrayList<>();
    
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
