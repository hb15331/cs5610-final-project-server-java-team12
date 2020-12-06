package com.example.cs5610finalprojectserver.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    private Integer customerId;
    private Integer delivererId;
    private String items;
    private String image;
    private String name;
    private String username;

    public Integer getDelivererId() {
        return delivererId;
    }

    public void setDelivererId(Integer delivererId) {
        this.delivererId = delivererId;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public Order(Integer orderId, String name, Integer customerId,
                 String username, String items,
                 Integer delivererId, String image) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.name = name;
        this.items = items;
        this.delivererId = delivererId;
        this.image = image;
        this.username = username;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Order() {

    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public String getItems() {
        return items;
    }

    //TODO: list of items???? private List items???
}
