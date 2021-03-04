package com.example.comfystore;

import com.example.comfystore.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ComfyStoreApplication {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(ComfyStoreApplication.class, args);
    }
}
