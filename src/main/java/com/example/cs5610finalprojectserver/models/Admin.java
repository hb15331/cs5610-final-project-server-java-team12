package com.example.cs5610finalprojectserver.models;


import javax.persistence.*;

@Entity
@Table(name="admins")

public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;
    private String firstName;
    private String lastName;
    private String email;

    public Admin() {

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Admin(Integer adminId, String firstName, String lastName,
                 String email) {
        this.adminId = adminId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public String getEmail() {
        return email;
    }

    public Admin(Integer adminId, String email) {
        this.adminId = adminId;
        this.email = email;
    }
}
