package com.project.api.entities;

import com.project.api.listeners.AuditEntityListener;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;

@Entity
@Table(name = Product.table_name)
@EntityListeners(AuditEntityListener.class)
public class Product extends BaseEntity{
    public final static String table_name = "products";

    private String name;
    private Double price;

}
