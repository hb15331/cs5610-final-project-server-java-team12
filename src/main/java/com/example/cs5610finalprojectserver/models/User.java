package com.example.cs5610finalprojectserver.models;

import javax.persistence.*;

@Entity
@Table(name="users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String type;
    private String firstName;
    private String lastName;
    private String email;

    public User() {

    }
    public User(Integer adminId, String firstName, String lastName,
                String email, String type) {
        this.userId = adminId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.type = type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }






}
