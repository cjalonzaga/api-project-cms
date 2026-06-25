package com.project.api.entities.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.project.api.entities.Category;
import com.project.api.entities.dtos.CategoryDto;

public class CategoryMapper extends AbstractMapper<CategoryDto , Category>{

	protected CategoryMapper(ModelMapper modelMapper) {
		super(modelMapper);
	}

	@Override
	public CategoryDto toDto(Category entity) {
		return modelMapper.map(entity , CategoryDto.class);
	}

	@Override
	public Category toEntity(CategoryDto dto) {
		return modelMapper.map(dto , Category.class);
	}

	@Override
	public List<CategoryDto> toDtoList(List<Category> entityList) {
		return entityList.stream().map( obj ->
        modelMapper.map(obj, CategoryDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<Category> toEntityList(List<CategoryDto> dtoList) {
		// TODO Auto-generated method stub
		return null;
	}

}
