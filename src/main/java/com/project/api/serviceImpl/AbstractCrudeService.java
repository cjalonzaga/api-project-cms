package com.project.api.serviceImpl;


import org.springframework.data.jpa.repository.JpaRepository;

import com.project.api.services.CrudService;

public abstract class AbstractCrudeService<E , ID> implements CrudService<E , ID>{

	protected abstract JpaRepository<E, ID> repository();
	
	@Override
	public E save(E entity) {
		return repository().save(entity);
	}

	@Override
	public void delete(ID id) {
		repository().deleteById(id);
	}

	@Override
	public E findById(ID id) {
		return repository().findById(id).orElseThrow();
	}
	
}
