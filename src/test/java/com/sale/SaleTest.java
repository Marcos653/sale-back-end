package com.sale;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import com.sale.Model.Sale;
import com.sale.Model.Seller;
import com.sale.repository.SaleRepository;
import com.sale.repository.SellerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SaleTest {

    @Autowired
    private SaleRepository saleRepository;
  
    @Autowired
    private SellerRepository sellerRepository;


    @Test(expected = DataIntegrityViolationException.class)
    public void saveSaleWithoutSeller() {
      LocalDate dateSale = LocalDate.of(2022, 4, 20);
      Sale sale = new Sale(1L, dateSale, 500.0, null);
      saleRepository.save(sale);
    }

    @Test
    public void saveSale() {
      LocalDate dateSale = LocalDate.of(2018, 8, 23);
      Seller seller = new Seller(1L, "Paulo", null);
      sellerRepository.save(seller);
      Sale sale = new Sale(1L, dateSale, 500.0, seller);
      Sale saveSale = saleRepository.save(sale);
      Assert.assertEquals(saveSale.getId(), sale.getId());
      saleRepository.deleteAll();
    }

}
