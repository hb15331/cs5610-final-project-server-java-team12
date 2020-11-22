package com.example.cs5610finalprojectserver.models;

import javax.persistence.*;

@Entity
@Table(name="customers")

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    private String firstname;
    private String lastname;
    private String location;
    private String email;
    private Integer credNum;
    private Integer orderId;

    public Customer(Integer customerId, String firstName, String lastName, String location) {
        this.customerId = customerId;
        this.firstname = firstName;
        this.lastname = lastName;
        this.location = location;
    }
    public Customer(){

    }

    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }

    public void setLastName(String lastName) {
        this.lastname = lastName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCredNum(Integer credNum) {
        this.credNum = credNum;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getFirstName() {
        return firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public String getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public Integer getCredNum() {
        return credNum;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public Integer getOrderId() {
        return orderId;
    }



}
