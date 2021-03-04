package com.example.comfystore.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "brand_id")
    private Integer brandId;

    @Column(name = "brand_name")
    private String name;

    public Brand(String name, Integer brandId) {
        this.name = name;
        this.brandId = brandId;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    private List<Product> product;

    public List<Product> getProduct() {
        return product;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "brand")
    private List<Model> model;

    public List<Model> getModel() {
        return model;
    }

    public void setModel(List<Model> model) {
        this.model = model;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Brand() {
    }

    @Override
    public String toString() {
        return "\nBrand{" +
                "name='" + name + '\'' +
                ", brandId=" + brandId +
                ", product=" + product +
                '}';
    }
}
