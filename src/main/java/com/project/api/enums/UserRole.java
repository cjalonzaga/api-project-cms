package com.project.api.enums;

public enum UserRole {

    ADMIN("Admin"),
    USER("User");

    private String name;

    UserRole(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

}
