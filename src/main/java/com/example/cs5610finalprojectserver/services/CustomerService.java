package com.example.cs5610finalprojectserver.services;

import com.example.cs5610finalprojectserver.models.Customer;
import com.example.cs5610finalprojectserver.reposetories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    List<Customer> customers = new ArrayList<Customer>();

    {
        customers.add(new Customer(123,"Charlie", "Smith", "Boston"));
        customers.add(new Customer(456,"Anne", "Kim", "New York"));
        customers.add(new Customer(456,"Anne", "Kim", "New York"));
    }

    /*
        Can be used by the admin to find all customer users.
     */
    public List<Customer>findAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    public Customer findCustomerById(Integer customerId) {
        return customerRepository.findById(customerId).get();
    }

    public Customer createCustomer(Customer customer) {
//        widget.setTopicId(tid);
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(
            Integer customerId,
            Customer newCustomer) {
        Optional customerO = customerRepository.findById(customerId);
        if (customerO.isPresent()) {
            Customer customer = (Customer) customerO.get();
            customer.setFirstName(newCustomer.getFirstName());
            customer.setLastName(newCustomer.getLastName());
            customer.setLocation(newCustomer.getLocation());
            customer.setEmail(newCustomer.getEmail());

            return customerRepository.save(customer);
        } else {
            return null;
        }
    }

    public void deleteCustomer(Integer cid) {
        customerRepository.deleteById(cid);
    }
}
