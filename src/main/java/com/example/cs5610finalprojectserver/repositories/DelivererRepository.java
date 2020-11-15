package com.example.cs5610finalprojectserver.repositories;

import com.example.cs5610finalprojectserver.models.Customer;
import com.example.cs5610finalprojectserver.models.Deliverer;
import org.springframework.data.repository.CrudRepository;

public interface DelivererRepository extends CrudRepository<Deliverer,Integer> {
}
