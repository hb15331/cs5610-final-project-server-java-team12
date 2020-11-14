package com.example.cs5610finalprojectserver.reposetories;

import com.example.cs5610finalprojectserver.models.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends CrudRepository<Customer,Integer>{
}

