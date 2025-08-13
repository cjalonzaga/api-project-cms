package com.project.api.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(
            name = "isValid",
            nullable = false,
            updatable = true,
            columnDefinition = "boolean default true"
    )
    private Boolean isValid;

    @Basic
    @Column(
            name = "createdOn",
            nullable = false,
            updatable = true
    )
    private LocalDateTime createdOn;

    @Basic
    @Column(
            name = "updatedOn",
            nullable = false,
            updatable = true
    )
    private LocalDateTime updatedOn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getValid() {
        if(isValid == null){
            return Boolean.TRUE;
        }
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    public LocalDateTime getCreatedOn() {
        if (createdOn == null){
            return LocalDateTime.now();
        }
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        if (updatedOn == null){
            return LocalDateTime.now();
        }
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }
}
