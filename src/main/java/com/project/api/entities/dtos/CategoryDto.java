package com.project.api.entities.dtos;

import java.util.List;
import java.util.Set;

public class CategoryDto {
	
	private Long id;
	
	private String name;
	
	private String description;
	
	private CategoryDto parent;
	
	private List<CategoryDto> children;
	
	private Set<ProductCategoryDto> productCategorySet;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CategoryDto getParent() {
		return parent;
	}

	public void setParent(CategoryDto parent) {
		this.parent = parent;
	}

	public List<CategoryDto> getChildren() {
		return children;
	}

	public void setChildren(List<CategoryDto> children) {
		this.children = children;
	}

	public Set<ProductCategoryDto> getProductCategorySet() {
		return productCategorySet;
	}

	public void setProductCategorySet(Set<ProductCategoryDto> productCategorySet) {
		this.productCategorySet = productCategorySet;
	}
}
