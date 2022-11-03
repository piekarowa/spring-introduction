package com.codecool.springdependencyinjection;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

public class Product {

    private static final AtomicInteger stupidIdGenerator = new AtomicInteger(1);

    private final long id;
    private BigDecimal price;

    public Product(BigDecimal price) {
        this.id = stupidIdGenerator.getAndIncrement();
        this.price = price;
    }

    public void applyDiscount(BigDecimal discount){
        this.price = price.subtract(discount);
    }

    public long getId() {
        return this.id;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
