package com.project.api.entities.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.project.api.entities.Product;
import com.project.api.entities.dtos.ProductDto;

public class ProductMapper extends AbstractMapper<ProductDto , Product>{

	protected ProductMapper(ModelMapper modelMapper) {
		super(modelMapper);
	}

	@Override
	public ProductDto toDto(Product entity) {
		return modelMapper.map(entity , ProductDto.class);
	}

	@Override
	public Product toEntity(ProductDto dto) {
		return modelMapper.map(dto , Product.class);
	}

	@Override
	public List<ProductDto> toDtoList(List<Product> entityList) {
		return entityList.stream().map( obj ->
        modelMapper.map(obj, ProductDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<Product> toEntityList(List<ProductDto> dtoList) {
		return dtoList.stream().map( obj ->
        modelMapper.map(obj, Product.class)).collect(Collectors.toList());
	}

}
