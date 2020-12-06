//package com.example.cs5610finalprojectserver.services;
//
//import com.example.cs5610finalprojectserver.models.User;
//import com.example.cs5610finalprojectserver.models.Customer;
//import com.example.cs5610finalprojectserver.repositories.AdminRepository;
//import com.example.cs5610finalprojectserver.repositories.CustomerRepository;
//import com.example.cs5610finalprojectserver.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserService {
//    @Autowired
//    UserRepository userRepository;
//
//    List<User> user = new ArrayList<User>();
//
//    /*
//        DO WE NEED THESE???
//     */
//    public List<User>findAllUsers() {
//        return (List<User>) userRepository.findAll();
//    }
//
//    public User createUser(User user) {
//        return userRepository.save(user);
//    }
//
//    public User updateUser(
//            Integer userId,
//            User newUser) {
//        Optional userO = userRepository.findById(userId);
//        if (userO.isPresent()) {
//            User user = (User) userO.get();
//            user.setFirstName(newUser.getFirstName());
//            user.setLastName(newUser.getLastName());
//            user.setEmail(newUser.getEmail());
//
//            return userRepository.save(user);
//        } else {
//            return null;
//        }
//    }
//
//    public void deleteUser(Integer uid) {
//        userRepository.deleteById(uid);
//    }
//}
