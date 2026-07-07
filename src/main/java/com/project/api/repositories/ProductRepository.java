package com.project.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.api.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
