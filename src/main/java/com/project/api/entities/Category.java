package com.project.api.entities;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.api.listeners.AuditEntityListener;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = Category.table_name)
@EntityListeners(AuditEntityListener.class)
public class Category extends BaseEntity{
	private final static String table_name = "categories";
	
	@Basic
    @Column(name = "name")
	private String name;
	
	@Basic
    @Column(name = "description" , columnDefinition = "TEXT")
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
	private Category parent;
	
	@OneToMany(mappedBy = "parent",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
	@JsonIgnore
	private List<Category> children;
	
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private Set<ProductCategory> productCategorySet;

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

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public List<Category> getChildren() {
		return children;
	}

	public void setChildren(List<Category> children) {
		this.children = children;
	}
	
	public void addChild(Category child) {
        children.add(child);
        child.setParent(this);
    }

    public void removeChild(Category child) {
        children.remove(child);
        child.setParent(null);
    }

	public Set<ProductCategory> getProductCategorySet() {
		return productCategorySet;
	}

	public void setProductCategorySet(Set<ProductCategory> productCategorySet) {
		this.productCategorySet = productCategorySet;
	}
}
