package com.project.api.serviceImpl;


import org.springframework.data.jpa.repository.JpaRepository;

import com.project.api.entities.BaseEntity;
import com.project.api.services.CrudService;

import jakarta.persistence.EntityNotFoundException;

public abstract class AbstractCrudeService<E extends BaseEntity, ID> implements CrudService<E , ID>{

	protected abstract JpaRepository<E, ID> repository();
	
	@Override
	public E save(E entity) {
		return repository().save(entity);
	}

	@Override
	public void delete(ID id) {
		E entity = repository().findById(id).orElseThrow( () -> new EntityNotFoundException("Entity not found") );
		entity.setValid(false);
		repository().save(entity);
	}

	@Override
	public E findById(ID id) {
		return repository().findById(id).orElseThrow();
	}
	
}
