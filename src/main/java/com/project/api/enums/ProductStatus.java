package com.project.api.enums;

public enum ProductStatus {
	PUBLISHED("Publish"),
    DRAFT("Draft");

    private String name;

    ProductStatus(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
