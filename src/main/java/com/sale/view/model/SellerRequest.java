package com.sale.view.model;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class SellerRequest {

    @NotNull @NotEmpty
    private String name;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
