package com.sale;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sale.Model.Seller;
import com.sale.repository.SellerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SellerTest {

    @Autowired
    private SellerRepository sellerRepository;
  
  
    @Test()
    public void registerSeller() {
      Seller seller = new Seller(1L, "Baker uncle", null);
      Seller saveSeller = sellerRepository.save(seller);
      Assert.assertEquals(saveSeller.getName(), seller.getName());
    }
  
    @Test()
    public void registerWithoutName() {
      Seller seller = new Seller(1L, null, null);
      sellerRepository.save(seller);
    }
  
    @Test
    public void getAllSeller() {
      Seller firstSeller= new Seller(13L, "Banker", null);
      Seller secondSeller = new Seller(14L, "Butcher", null);
      Seller thirdSeller = new Seller(15L, "Lawyer", null);
  
      sellerRepository.save(firstSeller);
      sellerRepository.save(secondSeller);
      sellerRepository.save(thirdSeller);
      List<Seller> sellers = sellerRepository.findAll();
  
      //Há 12 vendedores cadastrado por padrão no banco SQL
      Assert.assertEquals(sellers.size(), 15);
    }

}
