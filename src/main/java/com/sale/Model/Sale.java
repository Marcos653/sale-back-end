package com.sale.Model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    @Column(name = "date")
    private LocalDateTime date = LocalDateTime.now();
    @Column(name = "price")
    private Double price;
    @Column(name = "id_seller")
    private Long seller_id;
    // @Column(name = "seller_name")
    // private String seller_name;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="seller_id", nullable=false)
    private Seller seller;


    public Sale() {
    }


    public Sale(Long id, LocalDateTime date, Double price, Seller seller) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.seller = seller;
    }

    

    

    public Sale(Long id, LocalDateTime date, Double price, Long seller_id, Seller seller) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.seller_id = seller_id;
        this.seller = seller;
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

    public LocalDateTime getdate() {
        return date;
    }

    public void setdate(LocalDateTime date) {
        this.date = date;
    }

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
