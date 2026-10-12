package com.project.api.entities.mappers;

import org.modelmapper.ModelMapper;

import com.project.api.entities.StoreFrontConfig;
import com.project.api.entities.dtos.StoreFrontConfigDto;

public class StoreFrontConfigMapper extends AbstractMapper<StoreFrontConfigDto , StoreFrontConfig>{

	public StoreFrontConfigMapper(ModelMapper modelMapper, Class<StoreFrontConfigDto> dtoClass,
			Class<StoreFrontConfig> entityClass) {
		super(modelMapper, dtoClass, entityClass);
	}

}
