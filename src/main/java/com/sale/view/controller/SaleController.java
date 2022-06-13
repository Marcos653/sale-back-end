package com.sale.view.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sale.Model.Sale;
import com.sale.service.SaleService;
import com.sale.shared.SaleDTO;
import com.sale.view.model.SaleRequest;
import com.sale.view.model.SaleResponse;
import com.sale.view.model.SaleUpdate;
import com.sale.view.model.SellerFilter;

@RestController
@RequestMapping("api/sale")
public class SaleController {
    
    @Autowired
    private SaleService service;

    @GetMapping
    public ResponseEntity<List<SaleResponse>> getSales(){
        List<SaleDTO> saleDTOs = service.getAllSale();

        if(saleDTOs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<SaleResponse> saleResponses = saleDTOs.stream()
            .map(s -> mapper.map(s, SaleResponse.class))
            .collect(Collectors.toList());

            
        return new ResponseEntity<>(saleResponses, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SaleResponse> getById(@PathVariable Long id){

        Optional<SaleDTO> sale = service.getById(id);

        if(sale.isPresent()){
            return new ResponseEntity<>(new ModelMapper().map(sale.get(), SaleResponse.class),HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "/filter-date")
    public Stream<SellerFilter> test(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateStart,
                                            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateEnd){
        List<Sale> sales = service.findAllDataBetween(dateStart, dateEnd);
        Period period = Period.between(dateStart, dateEnd);
        float days = period.getDays();
        List<SellerFilter> SellerFilters;

        SellerFilters = sales.stream()
            .collect(Collectors.groupingBy(Sale::getSeller))
            .entrySet()
            .stream()
            .map(e -> {
                float totalValue = 0;
                float average = 0;
                for(Sale sale : e.getValue()){
                    totalValue = e.getValue().size();
                }
                average = (totalValue / days);
                return new SellerFilter(e.getKey(), totalValue, average);
            }).collect(Collectors.toList());

        return SellerFilters.stream()
            .sorted(Comparator.comparing(SellerFilter::getTotal_sales).reversed());
        
    }

    @PostMapping
    public ResponseEntity<SaleRequest> createSale(@RequestBody @Valid SaleRequest sale){
        ModelMapper mapper = new ModelMapper();
        SaleDTO saleDTO = mapper
            .map(sale, SaleDTO.class);
        saleDTO = service.register(saleDTO);
        return new ResponseEntity<>(mapper.map(saleDTO, SaleRequest.class), HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<SaleUpdate> updateSale(@RequestBody @Valid SaleUpdate newSale, @PathVariable Long id){
        ModelMapper mapper = new ModelMapper();
        SaleDTO saleDTO = mapper
            .map(newSale, SaleDTO.class);

        if(newSale.getPrice() != null){
            saleDTO = service.partialUpdateSale(id, newSale.getPrice()); 
        }
        
        return new ResponseEntity<>(mapper.map(saleDTO, SaleUpdate.class), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable Long id){
        service.deleteSale(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
