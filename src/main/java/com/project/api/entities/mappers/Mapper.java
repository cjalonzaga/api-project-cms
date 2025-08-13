package com.project.api.entities.mappers;

import java.util.List;

public interface Mapper <D , E>{
    D toDto(E entity);
    E toEntity(D dto);

    List<D> toDtoList(List<E> entityList);
    List<E> toEntityList(List<D> dtoList);
}
