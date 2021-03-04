package com.example.comfystore.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
public class Product {

    @Id
    @Column(name = "serial_number")
    private Integer serialNumber;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "status")
    private String status;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product")
    private List<Brand> brand;

    public List<Brand> getBrand() {
        return brand;
    }

    public void setBrand(List<Brand> brand) {
        this.brand = brand;
    }

    public Product() {
    }

    public Product(Integer serialNumber, LocalDate date, String status) {
        this.serialNumber = serialNumber;
        this.date = date;
        this.status = status;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "\nProduct{" +
                "serialNumber=" + serialNumber +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", brand=" + brand +
                '}';
    }
}