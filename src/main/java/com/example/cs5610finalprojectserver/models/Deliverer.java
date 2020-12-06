package com.example.cs5610finalprojectserver.models;

import javax.persistence.*;

@Entity
@Table(name="deliverer")

public class Deliverer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer delivererId;
    private String firstName;
    private String lastName;
    private String location;
    private String email;

    public Deliverer() {

    }

    public Deliverer(Integer delivererId, String firstName, String lastName,
                     String location, String email) {
        this.delivererId = delivererId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
        this.email = email;
    }

    public void setDelivererId(Integer delivererId) {
        this.delivererId = delivererId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDelivererId() {
        return delivererId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }
}
