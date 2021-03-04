package com.example.comfystore.service;

import com.example.comfystore.model.Product;
import com.example.comfystore.repo.BrandRepository;
import com.example.comfystore.repo.ModelRepository;
import com.example.comfystore.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
public abstract class ComfyService {

    @Autowired
    private ProductRepository pr;

    @Autowired
    private BrandRepository br;

    @Autowired
    private ModelRepository mr;

    protected ComfyService() {
    }

    public Product create(Product product) {
        return pr.save(product);
    }

    @Query(value = "SELECT COUNT * FROM model WHERE model_id=INT")
    public List<Model> list() {
        return mr.findAllByModelId();
    }

    public Optional<Product> find(Integer serialNumber) {
        return pr.findById(serialNumber);
    }

    @Query(value = "WHERE NOW() BETWEEN DATE_SUB(date,INTERVAL 14 DAY) AND date")
    public Product update(Product updatedProduct, Integer serialNumber) {
        return pr.findById(serialNumber)
                .map(product -> {
                    product.setSerialNumber(updatedProduct.getSerialNumber());
                    product.setDate(updatedProduct.getDate());
                    product.setStatus(updatedProduct.getStatus());
                    return pr.save(product);
                })
                .orElseGet(() -> {
                    updatedProduct.setSerialNumber(serialNumber);
                    return pr.save(updatedProduct);
                });
    }

    public void delete(Integer serialNumber) {
        pr.deleteBySerialNumber(serialNumber);
    }
}
