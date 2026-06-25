package com.project.api.entities;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.api.listeners.AuditEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = ProductCategory.table_name)
@EntityListeners(AuditEntityListener.class)
public class ProductCategory extends BaseEntity{
	private final static String table_name = "product_category";
	
	@ManyToOne(targetEntity = Product.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	@JsonIgnore
	private Product product;
	
	@ManyToOne(targetEntity = Category.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	@JsonIgnore
	private Category category;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
