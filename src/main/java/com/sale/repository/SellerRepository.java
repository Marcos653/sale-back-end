package com.sale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sale.Model.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
    
}
