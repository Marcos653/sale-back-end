package com.sale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sale.Model.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    
}
