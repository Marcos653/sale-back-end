package com.sale.service;

import java.util.List;
import java.util.Optional;

import com.sale.shared.SellerDTO;

public interface SellerService {
    List<SellerDTO> getAllSeller();
    SellerDTO register(SellerDTO seller);
    Optional<SellerDTO> getById(Long id);
    void deleteSeller(Long id);
    SellerDTO updateSeller(Long id, SellerDTO newSeller);
    SellerDTO partialUpdateSeller(Long id, String name);
}
