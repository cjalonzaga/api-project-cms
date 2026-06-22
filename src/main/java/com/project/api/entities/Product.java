package com.project.api.entities;

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


}
