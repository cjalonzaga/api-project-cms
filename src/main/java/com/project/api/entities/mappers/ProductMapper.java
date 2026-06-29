package com.project.api.entities.mappers;

import java.util.List;

import org.modelmapper.ModelMapper;

import com.project.api.entities.Product;
import com.project.api.entities.User;
import com.project.api.entities.dtos.ProductDto;
import com.project.api.entities.dtos.UserDto;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> toEntityList(List<ProductDto> dtoList) {
		// TODO Auto-generated method stub
		return null;
	}

}
