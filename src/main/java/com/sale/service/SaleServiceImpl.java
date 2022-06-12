package com.sale.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sale.Model.Sale;
import com.sale.Model.Seller;
import com.sale.repository.SaleRepository;
import com.sale.repository.SellerRepository;
import com.sale.shared.SaleDTO;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public List<SaleDTO> getAllSale() {
        List<Sale> sales = saleRepository.findAll();
        return sales.stream()
            .map(s -> new ModelMapper().map(s, SaleDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public SaleDTO register(SaleDTO sale) {
        return salveSale(sale);
    }

    @Override
    public Optional<SaleDTO> getById(Long id) {
        Optional<Sale> sale = saleRepository.findById(id);

        if(sale.isPresent()){
            return Optional.of(new ModelMapper()
                .map(sale.get(), SaleDTO.class));
        }

        return Optional.empty();

    }

    @Override
    public void deleteSale(Long id) {
        saleRepository.deleteById(id);
        
    }

    @Override
    public SaleDTO updateSale(Long id, SaleDTO newSale) {
        newSale.setId(id);
        return salveSale(newSale);
    }

    private SaleDTO salveSale(SaleDTO sale) {
        Optional<Seller> seller = sellerRepository.findById(sale.getSeller_id());
        sale.setSeller(seller.get());
        sale.setSeller_id(sale.getSeller_id());
        ModelMapper mapper = new ModelMapper();
        Sale sale_entity = mapper.map(sale, Sale.class);
        sale_entity = saleRepository.save(sale_entity);
        return mapper.map(sale_entity, SaleDTO.class);
    }

    @Override
    public SaleDTO partialUpdateSale(Long id, Double price, Seller seller) {
        ModelMapper mapper = new ModelMapper();
        Optional<Sale> sale = saleRepository.findById(id);

        if(sale.isPresent()){

            if(price != 0){
                sale.get().setPrice(price);;
                saleRepository.save(sale.get());
            }

            if(seller != null){
                sale.get().setSeller(seller);
                saleRepository.save(sale.get());
            }

            return mapper.map(sale.get(), SaleDTO.class);

        }

        return null;
        
    }
    
}
