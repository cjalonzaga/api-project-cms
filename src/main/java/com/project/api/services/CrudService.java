package com.project.api.services;

public interface CrudService<E , ID> {
	E save( E entity);
	void delete(ID id);
	E findById(ID id);
}
