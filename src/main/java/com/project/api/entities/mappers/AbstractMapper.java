package com.project.api.entities.mappers;

import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;

public abstract class AbstractMapper<D , E>{

	private final ModelMapper modelMapper;
	private final Class<D> dtoClass;
    private final Class<E> entityClass;

    public AbstractMapper(ModelMapper modelMapper , Class<D> dtoClass , Class<E> entityClass) {
        this.modelMapper = modelMapper;
        this.dtoClass = dtoClass;
        this.entityClass = entityClass;
    }

    public D toDto(E entity) {
        return modelMapper.map(entity, dtoClass);
    }

    public E toEntity(D dto) {
        return modelMapper.map(dto, entityClass);
    }
    
    public List<D> toDtoList(List<E> entities) {
    	
    	if (entities == null || entities.isEmpty()) {
            return Collections.emptyList();
        }
    	
        return entities.stream()
                .map(this::toDto)
                .toList();
    }

    public List<E> toEntityList(List<D> dtos) {
    	if (dtos == null || dtos.isEmpty()) {
            return Collections.emptyList();
        }
        return dtos.stream()
                .map(this::toEntity)
                .toList();
    }

}
