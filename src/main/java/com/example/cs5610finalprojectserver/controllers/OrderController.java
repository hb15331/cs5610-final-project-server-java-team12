package com.example.cs5610finalprojectserver.controllers;


import com.example.cs5610finalprojectserver.models.Customer;
import com.example.cs5610finalprojectserver.models.Order;
import com.example.cs5610finalprojectserver.services.CustomerService;
import com.example.cs5610finalprojectserver.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    OrderService service;

    @GetMapping("/api/orders")
    public List<Order> findAllOrders() {
        return service.findAllOrders();
    }

    /*
    Used to find orders by Id
     */
    @GetMapping("/api/orders/{oid}")
    public Order findOrderById(
            @PathVariable("oid") Integer orderId) {
        return service.findOrderById(orderId);
    }

    /*
   Used to create an order by each customer
    */
    @PostMapping("/api/orders")
    public Order createOrder(
            @RequestBody Order order) {
        return service.createOrder(order);
    }

    /*
   Used to update each order.
    */
    @PutMapping("/api/orders/{oid}")
    public Order updateOrder(
            @PathVariable("oid") Integer orderId,
            @RequestBody Order newOrder) {
        return service.updateOrder(orderId, newOrder);
    }

     /*
    Used for admins to delete customers from the database.
     */

    @DeleteMapping("/api/orders/{oid}")
    public void deleteOrder(
            @PathVariable("oid") Integer oid) {
        service.deleteOrder(oid);
    }
}
