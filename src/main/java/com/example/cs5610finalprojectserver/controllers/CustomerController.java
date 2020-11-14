package com.example.cs5610finalprojectserver.controllers;

import com.example.cs5610finalprojectserver.models.Customer;
import com.example.cs5610finalprojectserver.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    CustomerService service;

    @GetMapping("/api/customers")
    public List<Customer> findAllCustomers() {
        return service.findAllCustomers();
    }

    /*
    Used to add a customer to the database when they register.
     */
    @PostMapping("/api/customers")
    public Customer createCustomer(
            @RequestBody Customer customer) {
        return service.createCustomer(customer);
    }

    /*
    Used to update user profile.
     */
    @PutMapping("/api/customers/{cid}")
    public Customer updateCustomer(
            @PathVariable("cid") Integer customerId,
            @RequestBody Customer newCustomer) {
        return service.updateCustomer(customerId, newCustomer);
    }


    /*
    Used for admins to delete customers from the database.
     */

    @DeleteMapping("/api/customers/{cid}")
    public void deleteCustomer(
            @PathVariable("cid") Integer cid) {
        service.deleteCustomer(cid);
    }

}

