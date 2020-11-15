package com.example.cs5610finalprojectserver.controllers;

import com.example.cs5610finalprojectserver.models.Admin;
import com.example.cs5610finalprojectserver.models.Customer;
import com.example.cs5610finalprojectserver.services.AdminService;
import com.example.cs5610finalprojectserver.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class AdminController {
    @Autowired
    AdminService service;

    @GetMapping("/api/admins")
    public List<Admin> findAllAdmins() {
        return service.findAllAdmins();
    }

    /*
    Used to add an admin to the database when they register.
     */
    @PostMapping("/api/admins")
    public Admin createAdmin(
            @RequestBody Admin admin) {
        return service.createAdmin(admin);
    }

    /*
    Used to update admin profile.
     */
    @PutMapping("/api/admins/{aid}")
    public Admin updateAdmin(
            @PathVariable("aid") Integer adminId,
            @RequestBody Admin newAdmin) {
        return service.updateAdmin(adminId, newAdmin);
    }

/*
    Used for admins to delete customers from the database.
     */

    @DeleteMapping("/api/admins/{aid}")
    public void deleteAdmin(
            @PathVariable("aid") Integer aid) {
        service.deleteAdmin(aid);
    }
}
