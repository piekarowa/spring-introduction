package com.codecool.springdependencyinjection;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductServiceTest {


    //zakładamy, że cena produktu przed zniżką będzie różna od ceny po zniżce, metoda assert zwraca wynik liczbowy, jeśli to prawda to daje wynik -1, stąd to porównanie <0
    @Test
    void Test(){
        //given:
        ProductService productService = new ProductService(new ProductDiscountApplier());
        BigDecimal priceBeforeDiscount = productService.getProductBeforeDiscount().getPrice();

        //when:
        Product productAfterDiscount = productService.getProductAfterDiscount();

        //then:
        assertTrue(productAfterDiscount.getPrice().compareTo(priceBeforeDiscount) < 0);

    }

}
