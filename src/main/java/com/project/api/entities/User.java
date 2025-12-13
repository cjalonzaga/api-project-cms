package com.project.api.entities;

import com.project.api.enums.UserRole;
import com.project.api.listeners.AuditEntityListener;
import jakarta.persistence.*;

@Entity
@Table(name = User.name)
@EntityListeners(AuditEntityListener.class)
public class User extends BaseEntity{
    public final static String name = "users";

    @Basic
    @Column(
            name = "firstName",
            nullable = false,
            updatable = true
    )
    private String firstName;

    @Basic
    @Column(
            name = "lastName",
            nullable = false,
            updatable = true
    )
    private String lastName;

    @Basic
    @Column(
            name = "username",
            nullable = false,
            unique = true
    )
    private String username;

    @Basic
    @Column(
            name = "password",
            nullable = false,
            updatable = true
    )
    private String password;

    @Basic
    @Column(
            name = "userRole",
            nullable = false
    )
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Basic
    @Column(
            name = "email",
            nullable = false,
            updatable = true
    )
    private String email;

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "{" +
                "username :" + getUsername() + "," +
                "user_role :" + getUserRole().getName() + "," +
                "first_name :" + getFirstName()+"," +
                "last_name : " + getLastName()+"," +
                "}";
    }
}
