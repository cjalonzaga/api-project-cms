package com.project.api.entities.dtos;

import java.util.Set;

import com.project.api.entities.ProductCategory;
import com.project.api.enums.ProductStatus;

public class ProductDto {
	
	private Long id;
	
	private String name;
	
	private Double price;
	
	private Set<ProductCategoryDto> productCategorySet;
	
	private String description;
	
	private String shortDescription;
	
	 private ProductStatus status;

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

	 public Double getPrice() {
		 return price;
	 }

	 public void setPrice(Double price) {
		 this.price = price;
	 }

	 public Set<ProductCategoryDto> getProductCategorySet() {
		 return productCategorySet;
	 }

	 public void setProductCategorySet(Set<ProductCategoryDto> productCategorySet) {
		 this.productCategorySet = productCategorySet;
	 }

	 public String getShortDescription() {
		 return shortDescription;
	 }

	 public void setShortDescription(String shortDescription) {
		 this.shortDescription = shortDescription;
	 }

	 public ProductStatus getStatus() {
		 return status;
	 }

	 public void setStatus(ProductStatus status) {
		 this.status = status;
	 }

	 public String getDescription() {
		return description;
	 }

	 public void setDescription(String description) {
		this.description = description;
	 }
	 
	 
}
