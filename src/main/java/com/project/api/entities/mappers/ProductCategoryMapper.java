package com.project.api.entities.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.project.api.entities.ProductCategory;
import com.project.api.entities.dtos.ProductCategoryDto;
import com.project.api.entities.dtos.ProductDto;

public class ProductCategoryMapper extends AbstractMapper<ProductCategoryDto , ProductCategory>{

	protected ProductCategoryMapper(ModelMapper modelMapper) {
		super(modelMapper);
	}

	@Override
	public ProductCategoryDto toDto(ProductCategory entity) {
		return modelMapper.map(entity , ProductCategoryDto.class);
	}

	@Override
	public ProductCategory toEntity(ProductCategoryDto dto) {
		return modelMapper.map(dto , ProductCategory.class);
	}

	@Override
	public List<ProductCategoryDto> toDtoList(List<ProductCategory> entityList) {
		return entityList.stream().map( obj ->
        modelMapper.map(obj, ProductCategoryDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<ProductCategory> toEntityList(List<ProductCategoryDto> dtoList) {
		return dtoList.stream().map( obj ->
        modelMapper.map(obj, ProductCategory.class)).collect(Collectors.toList());
	}

}
