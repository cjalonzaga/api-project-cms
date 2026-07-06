package com.project.api.entities.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.project.api.entities.Category;
import com.project.api.entities.dtos.CategoryDto;

public class CategoryMapper extends AbstractMapper<CategoryDto , Category>{

	protected CategoryMapper(ModelMapper modelMapper) {
		super(modelMapper , CategoryDto.class , Category.class);
	}
	
}
