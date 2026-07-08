package com.project.api.services;

import com.project.api.entities.Product;
import com.project.api.entities.dtos.ProductDto;

public interface ProductService {
	ProductDto createProduct(ProductDto dto);
	ProductDto find(Long id);
}
