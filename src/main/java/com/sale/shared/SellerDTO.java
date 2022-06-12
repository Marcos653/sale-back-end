package com.sale.shared;

import java.util.List;

import com.sale.Model.Sale;
import com.sale.Model.Seller;

public class SellerDTO {

    private Long id;
    private String name;
    private List<Sale> sale;
    private Seller seller;
    private float total_sales;
    private float average_daily;
    

    
    public SellerDTO() {
    }



    public SellerDTO(Seller seller, float total_sales, float average_daily) {
        this.seller = seller;
        this.total_sales = total_sales;
        this.average_daily = average_daily;
    }

    public SellerDTO(Seller seller, float total_sales) {
        this.seller = seller;
        this.total_sales = total_sales;
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



    public List<Sale> getSale() {
        return sale;
    }



    public void setSale(List<Sale> sale) {
        this.sale = sale;
    }



    public Seller getSeller() {
        return seller;
    }



    public void setSeller(Seller seller) {
        this.seller = seller;
    }



    public float getTotal_sales() {
        return total_sales;
    }



    public void setTotal_sales(float total_sales) {
        this.total_sales = total_sales;
    }



    public float getAverage_daily() {
        return average_daily;
    }



    public void setAverage_daily(float average_daily) {
        this.average_daily = average_daily;
    }


    
  
    
}
