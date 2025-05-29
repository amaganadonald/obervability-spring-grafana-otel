package com.amagana.obervabilityspringgrafana;

import com.amagana.obervabilityspringgrafana.entities.Products;
import com.amagana.obervabilityspringgrafana.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class ObervabilitySpringGrafanaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ObervabilitySpringGrafanaApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Products.builder().name("Computers").description("Dell computers").price(BigDecimal.valueOf(3500.25)).build());
            productRepository.save(Products.builder().name("Phone").description("Mobile Phone").price(BigDecimal.valueOf(3500.25)).build());
            productRepository.save(Products.builder().name("Tv").description("Big screen").price(BigDecimal.valueOf(3500.25)).build());
            productRepository.save(Products.builder().name("Mouse").description("Mouse computers").price(BigDecimal.valueOf(3500.25)).build());
            productRepository.save(Products.builder().name("photos").description("photo computers").price(BigDecimal.valueOf(3500.25)).build());
            productRepository.findAll().forEach(System.out::println);
        };
    }

}
