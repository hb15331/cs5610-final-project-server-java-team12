package com.example.cs5610finalprojectserver.repositories;

import com.example.cs5610finalprojectserver.models.Admin;
import com.example.cs5610finalprojectserver.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin,Integer> {
}
