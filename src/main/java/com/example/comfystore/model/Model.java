package com.example.comfystore.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "model_id")
    private Integer modelId;

    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "model_name")
    private String modelName;


    @Column(name = "barcode")
    private String barCode;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id")
    private List<Brand> brand;

    public List<Brand> getBrand() {
        return brand;
    }

    public void setBrand(List<Brand> brand) {
        this.brand = brand;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Model() {
    }

    @Override
    public String toString() {
        return "\nModel{" +
                "modelId=" + modelId +
                ", brandName='" + brandName + '\'' +
                ", modelName='" + modelName + '\'' +
                ", barCode='" + barCode + '\'' +
                ", brand=" + brand +
                '}';
    }
}
