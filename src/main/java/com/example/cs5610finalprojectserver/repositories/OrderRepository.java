package com.example.cs5610finalprojectserver.repositories;

import com.example.cs5610finalprojectserver.models.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order,Integer> {

    @Query("SELECT order FROM Order order WHERE order.customerId=:customerId")
    List<Order> findOrderForUser(
            @Param("customerId") Integer customerId);

}
