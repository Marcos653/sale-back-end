package com.sale.shared;

import java.util.List;

import com.sale.Model.Sale;

public class SellerDTO {

    private Long id;
    private String name;
    private List<Sale> sale;
    

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
