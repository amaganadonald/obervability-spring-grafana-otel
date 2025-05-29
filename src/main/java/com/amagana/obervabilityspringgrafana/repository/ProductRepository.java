package com.amagana.obervabilityspringgrafana.repository;

import com.amagana.obervabilityspringgrafana.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
}
