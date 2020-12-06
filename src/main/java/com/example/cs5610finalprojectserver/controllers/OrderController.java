package com.example.cs5610finalprojectserver.controllers;


import com.example.cs5610finalprojectserver.models.Customer;
import com.example.cs5610finalprojectserver.models.Order;
import com.example.cs5610finalprojectserver.models.User;
import com.example.cs5610finalprojectserver.services.CustomerService;
import com.example.cs5610finalprojectserver.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.servlet.http.HttpSession;

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
Used to update each order.
 */
    @GetMapping("/api/orders/{cid}/orders")
    public List<Order> findOrderForUser(
            @PathVariable("cid") Integer customerId) {
        return service.findOrderForUser(customerId);
    }


    /*
Used to update each order.
 */
    @GetMapping("/api/orders/{cid}/orders")
    public List<Order> findOrderForUser(
            @PathVariable("cid") Integer customerId) {
        return service.findOrderForUser(customerId);
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
    public Order createOrder(@RequestBody Order order) {
//        HttpSession session = request;
//        User profile = (User)session.getAttribute("profile");
//        int userId = profile.getUserId();
//        order.setCustomerId(userId);
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
