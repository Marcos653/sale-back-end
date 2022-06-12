package com.sale.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "sellers")
public class Seller {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "created_at")
    private LocalDateTime created_at = LocalDateTime.now();
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "seller")
    @JsonManagedReference
    private List<Sale> sale;

    

    public Seller() {
    }

    public Seller(Long id, LocalDateTime  created_at, String name, List<Sale> sale) {
        this.id = id;
        this.created_at = created_at;
        this.name = name;
        this.sale = sale;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime  getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime  created_at) {
        this.created_at = created_at;
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
