package com.example.cs5610finalprojectserver.services;

import com.example.cs5610finalprojectserver.models.Customer;
import com.example.cs5610finalprojectserver.models.Order;
import com.example.cs5610finalprojectserver.repositories.CustomerRepository;
import com.example.cs5610finalprojectserver.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    List<Order> orders = new ArrayList<Order>();

    public List<Order> findAllOrders() {
        return (List<Order>) orderRepository.findAll();
    }

    public Order findOrderById(Integer orderId) {
        return orderRepository.findById(orderId).get();
    }

    public Order createOrder(Order order) {
//        widget.setTopicId(tid);
        return orderRepository.save(order);
    }

    public Order updateOrder(
            Integer orderId,
            Order newOrder) {
        Optional orderO = orderRepository.findById(orderId);
        if (orderO.isPresent()) {
            Order order = (Order) orderO.get();
            order.setCustomerId(newOrder.getCustomerId());
            order.setDelivererId(newOrder.getDelivererId());
            order.setItems(newOrder.getItems());
            return orderRepository.save(order);
        } else {
            return null;
        }
    }

    public void deleteOrder(Integer oid) {
        orderRepository.deleteById(oid);
    }

}
