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

    public Order(Integer orderId, Integer customerId, String items,
                 Integer delivererId, String image) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.items = items;
        this.delivererId = delivererId;
        this.image = image;

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
