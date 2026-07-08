package com.project.api.serviceImpl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.project.api.entities.Product;
import com.project.api.entities.dtos.ProductDto;
import com.project.api.entities.mappers.ProductMapper;
import com.project.api.repositories.ProductRepository;
import com.project.api.services.ProductService;

@Service
public class ProductServiceImpl extends AbstractCrudeService<Product , Long > implements ProductService{
	
	private final ProductRepository productRepository;
	private final ProductMapper mapper;
	
	ProductServiceImpl(ProductRepository productRepository , ProductMapper mapper){
		this.productRepository = productRepository;
		this.mapper = mapper;
	}
	
	@Override
	protected JpaRepository<Product, Long> repository() {
		return productRepository;
	}

	@Override
	public ProductDto createProduct(ProductDto dto) {
		
		Product entity = mapper.toEntity(dto);
		
		return mapper.toDto( save(entity) );
	}

	@Override
	public ProductDto find(Long id) {
	
		return  mapper.toDto( findById(id) );
	}

}
