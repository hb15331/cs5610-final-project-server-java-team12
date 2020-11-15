package com.example.cs5610finalprojectserver.services;

import com.example.cs5610finalprojectserver.models.Customer;
import com.example.cs5610finalprojectserver.models.Deliverer;
import com.example.cs5610finalprojectserver.repositories.CustomerRepository;
import com.example.cs5610finalprojectserver.repositories.DelivererRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DelivererService {
    @Autowired
    DelivererRepository delivererRepository;

    List<Deliverer> deliverers = new ArrayList<Deliverer>();

    /*
        Can be used by the admin to find all deliverer users.
     */
    public List<Deliverer>findAllDeliverer() {
        return (List<Deliverer>) delivererRepository.findAll();
    }

    public Deliverer createDeliverer(Deliverer deliverer) {
        return delivererRepository.save(deliverer);
    }

    public Deliverer updateDeliverer(
            Integer delivererId,
            Deliverer newDeliverer) {
        Optional delivererO = delivererRepository.findById(delivererId);
        if (delivererO.isPresent()) {
            Deliverer deliverer = (Deliverer) delivererO.get();
            deliverer.setFirstName(newDeliverer.getFirstName());
            deliverer.setLastName(newDeliverer.getLastName());
            deliverer.setLocation(newDeliverer.getLocation());
            deliverer.setEmail(newDeliverer.getEmail());

            return delivererRepository.save(deliverer);
        } else {
            return null;
        }
    }

    public void deleteDeliverer(Integer did) {
        delivererRepository.deleteById(did);
    }

}
