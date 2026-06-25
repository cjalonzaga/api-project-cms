package com.project.api.entities;

import java.util.Set;

import com.project.api.listeners.AuditEntityListener;
import jakarta.persistence.*;

@Entity
@Table(name = Product.table_name)
@EntityListeners(AuditEntityListener.class)
public class Product extends BaseEntity{
    public final static String table_name = "products";

    @Basic
    @Column(
            name = "name",
            nullable = false,
            updatable = true
    )
    private String name;

    @Basic
    @Column(
            name = "price",
            nullable = false,
            updatable = true
    )
    private Double price;
    
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private Set<ProductCategory> productCategorySet;

    public String getName() {
        return name;
    }
    
    @Basic
    @Column(name = "description" , columnDefinition = "TEXT")
    private String description;
    
    @Basic
    @Column(name = "short_description" , columnDefinition = "TEXT")
    private String shortDescription;

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

	public Set<ProductCategory> getProductCategorySet() {
		return productCategorySet;
	}

	public void setProductCategorySet(Set<ProductCategory> productCategorySet) {
		this.productCategorySet = productCategorySet;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}


}
