package com.project.api.entities.dtos;

public class ProductCategoryDto {
	private ProductDto product;
	
	private CategoryDto category;

	public ProductDto getProduct() {
		return product;
	}

	public void setProduct(ProductDto product) {
		this.product = product;
	}

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}
	
	
}
