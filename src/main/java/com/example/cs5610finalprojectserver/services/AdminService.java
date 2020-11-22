package com.example.cs5610finalprojectserver.services;

import com.example.cs5610finalprojectserver.models.Admin;
import com.example.cs5610finalprojectserver.models.Customer;
import com.example.cs5610finalprojectserver.repositories.AdminRepository;
import com.example.cs5610finalprojectserver.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;

    List<Admin> admin = new ArrayList<Admin>();

    /*
        DO WE NEED THESE???
     */
    public List<Admin>findAllAdmins() {
        return (List<Admin>) adminRepository.findAll();
    }

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin updateAdmin(
            Integer adminId,
            Admin newAdmin) {
        Optional adminO = adminRepository.findById(adminId);
        if (adminO.isPresent()) {
            Admin admin = (Admin) adminO.get();
            admin.setFirstName(newAdmin.getFirstName());
            admin.setLastName(newAdmin.getLastName());
            admin.setEmail(newAdmin.getEmail());

            return adminRepository.save(admin);
        } else {
            return null;
        }
    }

    public void deleteAdmin(Integer aid) {
        adminRepository.deleteById(aid);
    }
}
