package com.example.comfystore.controller;

import com.example.comfystore.model.Product;
import com.example.comfystore.service.ComfyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestController {

    private final ComfyService service;

    @Autowired
    public ProductRestController(ComfyService service) {
        this.service = service;
    }

    @GetMapping(params = "brand")
    public List<Model> collectCountOfProducts(@RequestParam String brand, Product product) {
        return service.list();
    }

    @PostMapping
    public Product getOnStockProduct(Product product) {
        return service.create(product);
    }

    @PutMapping("{id}")
    public void returnProduct(@RequestBody Product updatedProduct, @PathVariable Integer serialNumber) {
        service.update(updatedProduct, serialNumber);
    }

    @DeleteMapping("{id}")
    public void saleProduct(@PathVariable Integer serialNumber) {
        service.delete(serialNumber);
    }
}
