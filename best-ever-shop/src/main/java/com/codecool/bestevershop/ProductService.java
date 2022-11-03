package com.codecool.bestevershop;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();


    public List<Product> getAll() {
        return products;
    }

    public void add(Product product) {
        products.add(product);
    }

    public void delete(Integer id) {
        Product product = getProductById(id);

        if (product != null) {
            products.remove(product);
        }
    }

    public Product getProductById(Integer id) {

        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }

        return null;

    }

    private int getIndexById(Integer id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
                return i;
            }
        }

        return -1;
    }

    public void update(Product product) {

        int index = getIndexById(product.getId());

        if (index != -1) {
            products.get(index).setName(product.getName());
        }
    }
}
