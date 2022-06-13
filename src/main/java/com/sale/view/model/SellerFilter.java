package com.sale.view.model;

import com.sale.Model.Seller;

public class SellerFilter {

    private String name;
    private float total_sales;
    private float average_daily;



    public SellerFilter() {
    }


    public SellerFilter(Seller seller, float total_sales, float average_daily) {
        this.name = seller.getName();
        this.total_sales = total_sales;
        this.average_daily = average_daily;
    }




    public SellerFilter(String name, float total_sales, float average_daily) {
        this.name = name;
        this.total_sales = total_sales;
        this.average_daily = average_daily;
    }

    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
