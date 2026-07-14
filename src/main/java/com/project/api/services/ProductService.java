package com.project.api.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.api.entities.dtos.ProductDto;

public interface ProductService {
	ProductDto createProduct(ProductDto dto);
	ProductDto find(Long id);
	Page<ProductDto> findAllWithPaging(Pageable page);
}
