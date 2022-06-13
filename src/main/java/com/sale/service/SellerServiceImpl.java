package com.sale.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sale.Model.Sale;
import com.sale.Model.Seller;
import com.sale.repository.SellerRepository;
import com.sale.shared.SellerDTO;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerRepository repo;

    @Override
    public List<SellerDTO> getAllSeller() {
        List<Seller> sellers = repo.findAll();
        return sellers.stream()
            .map(s -> new ModelMapper().map(s, SellerDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public SellerDTO register(SellerDTO seller) {
        return salveSeller(seller);
    }

    @Override
    public Optional<SellerDTO> getById(Long id) {
        Optional<Seller> seller = repo.findById(id);

        if(seller.isPresent()){
             return Optional.of(new ModelMapper()
                 .map(seller.get(), SellerDTO.class)); 
        }
 
         return Optional.empty();
    }

    @Override
    public void deleteSeller(Long id) {
        repo.deleteById(id);
        
    }

    @Override
    public SellerDTO updateSeller(Long id, SellerDTO newSeller) {
        newSeller.setId(id);
        return salveSeller(newSeller);
    }

    private SellerDTO salveSeller(SellerDTO seller) {
        ModelMapper mapper = new ModelMapper();
        Seller seller_entity = mapper.map(seller, Seller.class);
        seller_entity = repo.save(seller_entity);
        return mapper.map(seller_entity, SellerDTO.class);
    }

    @Override
    public SellerDTO partialUpdateSeller(Long id, String name) {
        ModelMapper mapper = new ModelMapper();
        Optional<Seller> seller = repo.findById(id);

        if(seller.isPresent()){

            if(name != null){
                seller.get().setName(name);
                repo.save(seller.get());
            }
            
            return mapper.map(seller.get(), SellerDTO.class);

        }

        return null;
        
    }
    
}
