package com.sale.service;

import java.util.List;
import java.util.Optional;

import com.sale.Model.Seller;
import com.sale.shared.SaleDTO;

public interface SaleService {
    List<SaleDTO> getAllSale();
    SaleDTO register(SaleDTO sale);
    Optional<SaleDTO> getById(Long id);
    void deleteSale(Long id);
    SaleDTO updateSale(Long id, SaleDTO newSale);
    SaleDTO partialUpdateSale(Long id, Double price, Seller seller);
}
