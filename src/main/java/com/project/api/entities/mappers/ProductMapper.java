package com.project.api.entities.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.project.api.entities.Product;
import com.project.api.entities.dtos.ProductDto;

public class ProductMapper extends AbstractMapper<ProductDto , Product>{

	protected ProductMapper(ModelMapper modelMapper) {
		super(modelMapper , ProductDto.class , Product.class);
	}
}
