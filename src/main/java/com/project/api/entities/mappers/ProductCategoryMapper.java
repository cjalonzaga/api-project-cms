package com.project.api.entities.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.project.api.entities.ProductCategory;
import com.project.api.entities.dtos.ProductCategoryDto;
import com.project.api.entities.dtos.ProductDto;

public class ProductCategoryMapper extends AbstractMapper<ProductCategoryDto , ProductCategory>{

	protected ProductCategoryMapper(ModelMapper modelMapper) {
		super(modelMapper , ProductCategoryDto.class , ProductCategory.class);
	}
}
