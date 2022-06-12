package com.sale.view.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.sale.Model.Sale;

public class SellerRequest {

    @NotNull @NotEmpty
    private String name;
    @NotNull @NotEmpty
    private List<Sale> sale;


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
