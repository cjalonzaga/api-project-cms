package com.project.api.entities.mappers;

import org.modelmapper.ModelMapper;

public abstract class AbstractMapper <D , E> implements Mapper<D , E>{
    protected final ModelMapper modelMapper;

    protected AbstractMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

}
