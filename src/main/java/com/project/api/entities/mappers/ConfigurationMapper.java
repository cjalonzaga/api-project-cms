package com.project.api.entities.mappers;

import org.modelmapper.ModelMapper;

import com.project.api.entities.Configuration;
import com.project.api.entities.dtos.ConfigurationDto;

public class ConfigurationMapper extends AbstractMapper<ConfigurationDto , Configuration>{

	public ConfigurationMapper(ModelMapper modelMapper, Class<ConfigurationDto> dtoClass,
			Class<Configuration> entityClass) {
		super(modelMapper, dtoClass, entityClass);
	}

}
