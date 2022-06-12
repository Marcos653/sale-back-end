package com.sale.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.sale.Model.Sale;
import com.sale.Model.Seller;
import com.sale.shared.SaleDTO;

public interface SaleService {
    List<SaleDTO> getAllSale();
    SaleDTO register(SaleDTO sale);
    Optional<SaleDTO> getById(Long id);
    void deleteSale(Long id);
    SaleDTO updateSale(Long id, SaleDTO newSale);
    SaleDTO partialUpdateSale(Long id, Double price, Seller seller);
    List<Sale> findAllDataBetween(LocalDate dateStart, LocalDate dateEnd);
}
