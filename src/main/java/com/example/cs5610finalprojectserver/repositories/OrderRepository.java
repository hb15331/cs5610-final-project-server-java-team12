package com.example.cs5610finalprojectserver.repositories;

import com.example.cs5610finalprojectserver.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order,Integer> {
}
