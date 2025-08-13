package com.project.api.enums;

public enum AuditType {
    CREATE("Create"),
    UPDATE("Update"),
    DELETE("Delete");

    private final String name;

    AuditType(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
