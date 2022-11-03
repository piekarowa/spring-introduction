package com.codecool.bestevershop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class BestEverShopController {

    private final ProductService productService;

    public BestEverShopController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/list")
    public List<Product> getAll(){
    log.info("Returned all products");
    return productService.getAll();
}

    @PostMapping("/products/add")
    public void create(@RequestBody Product product) {
        log.info("Created new product: " + product);
        productService.add(product);
    }


        @DeleteMapping("/products/{id}")
        public void delete(@PathVariable Integer id){
            log.info("Deleted product with id " + id);
            productService.delete(id);
        }

    @GetMapping("/products/{id}")
    public Product getById(@PathVariable Integer id){
        log.info("Returned with id " + id);
        return productService.getProductById(id);
    }


    @PutMapping("/products/{id}")
    public void update(@RequestBody Product product){
        log.info("Updated message: " + product);
        productService.update(product);
    }










}
