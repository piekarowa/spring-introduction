package com.codecool.springdependencyinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzAutoConfiguration;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;

@Service
public class ProductService {

    private final Product product = new Product(BigDecimal.valueOf(23.50));

    private ProductDiscountApplier applier;

//    konstruktor
    public ProductService(ProductDiscountApplier applier) {
        this.applier = applier;
    }

    //    pole
//    @Autowired
//    private ProductDiscountApplier applier;

//    setter
//    @Autowired
//    public void setProductDiscountApplier(ProductDiscountApplier applier){
//        this.applier = applier;
//    }

    public Product getProductBeforeDiscount(){
        return product;
    }

    public Product getProductAfterDiscount(){
        return applier.applyDiscount(product);

    }


}
