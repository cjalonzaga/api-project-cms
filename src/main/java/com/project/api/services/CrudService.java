package com.project.api.services;

public interface CrudService<E , ID> {
	E create( E entity);
	E update(ID id , E entity);
	void delete(ID id);
	E findById(ID id);
}
