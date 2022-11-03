package com.codecool.springdependencyinjection;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Random;

@Component
public class ProductDiscountApplier {


    public Product applyDiscount(Product product){
        BigDecimal discount = getDiscount(product.getPrice());
        product.applyDiscount(discount);
        return product;
    }

    private BigDecimal getDiscount(BigDecimal price){
        BigDecimal randomDiscountFactor = BigDecimal.valueOf(new Random().nextDouble());
        return price.multiply(randomDiscountFactor);
    }
}
