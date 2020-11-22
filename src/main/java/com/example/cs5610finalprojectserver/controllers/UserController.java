package com.example.cs5610finalprojectserver.controllers;


import com.example.cs5610finalprojectserver.models.User;
import com.example.cs5610finalprojectserver.models.Customer;
import com.example.cs5610finalprojectserver.services.AdminService;
import com.example.cs5610finalprojectserver.services.CustomerService;
import com.example.cs5610finalprojectserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    UserService service;

    @GetMapping("/api/users")
    public List<User> findAllUsers() {
        return service.findAllUsers();
    }

    /*
    Used to add an admin to the database when they register.
     */
    @PostMapping("/api/users")
    public User createAdmin(
            @RequestBody User user) {
        return service.createUser(user);
    }

    /*
    Used to update admin profile.
     */
    @PutMapping("/api/users/{uid}")
    public User updateUser(
            @PathVariable("uid") Integer userId,
            @RequestBody User newUser) {
        return service.updateUser(userId, newUser);
    }

/*
    Used for admins to delete customers from the database.
     */

    @DeleteMapping("/api/users/{uid}")
    public void deleteAdmin(
            @PathVariable("uid") Integer uid) {
        service.deleteUser(uid);
    }
}
