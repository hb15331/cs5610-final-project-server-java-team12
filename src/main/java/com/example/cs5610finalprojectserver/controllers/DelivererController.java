package com.example.cs5610finalprojectserver.controllers;

import com.example.cs5610finalprojectserver.models.Customer;
import com.example.cs5610finalprojectserver.models.Deliverer;
import com.example.cs5610finalprojectserver.services.CustomerService;
import com.example.cs5610finalprojectserver.services.DelivererService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class DelivererController {

    @Autowired
    DelivererService service;

    @GetMapping("/api/deliverer")
    public List<Deliverer> findAllDeliverer() {
        return service.findAllDeliverer();
    }

    /*
   Used to add a deliverers to the database when they register.
    */
    @PostMapping("/api/deliverers")
    public Deliverer createDeliverer(
            @RequestBody Deliverer deliverer) {
        return service.createDeliverer(deliverer);
    }

    /*
   Used to update deliverer profile.
    */
    @PutMapping("/api/deliverers/{did}")
    public Deliverer updateDeliverer(
            @PathVariable("did") Integer delivererId,
            @RequestBody Deliverer newDeliverer) {
        return service.updateDeliverer(delivererId, newDeliverer);
    }

     /*
    Used for admins to delete deliverers from the database.
     */

    @DeleteMapping("/api/deliverers/{did}")
    public void deleteDeliverer(
            @PathVariable("did") Integer did) {
        service.deleteDeliverer(did);
    }
}
