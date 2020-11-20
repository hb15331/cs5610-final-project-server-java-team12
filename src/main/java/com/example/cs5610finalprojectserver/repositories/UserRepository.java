package com.example.cs5610finalprojectserver.repositories;

import com.example.cs5610finalprojectserver.models.User;
import com.example.cs5610finalprojectserver.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
