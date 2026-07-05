package com.project.api.entities.mappers;

import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MapperService {
	private final ModelMapper mapper;

    public MapperService(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public <D, E> D toDto(E entity, Class<D> dtoType) {
        return mapper.map(entity, dtoType);
    }

    public <D, E> E toEntity(D dto, Class<E> entityType) {
        return mapper.map(dto, entityType);
    }

    public <D, E> List<D> toDtoList(List<E> entities, Class<D> dtoType) {
        if (entities == null || entities.isEmpty()) {
            return List.of();
        }

        return entities.stream()
                .map(entity -> mapper.map(entity, dtoType))
                .toList();
    }

    public <D, E> List<E> toEntityList(List<D> dtos, Class<E> entityType) {
        if (dtos == null || dtos.isEmpty()) {
            return List.of();
        }

        return dtos.stream()
                .map(dto -> mapper.map(dto, entityType))
                .toList();
    }
}
