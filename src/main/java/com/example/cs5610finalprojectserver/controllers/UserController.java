package com.example.cs5610finalprojectserver.controllers;

import com.example.cs5610finalprojectserver.models.User;
import com.example.cs5610finalprojectserver.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }

    @PostMapping("/login")
    public User login(HttpSession session,
                      @RequestBody User user) {
        User profile = userRepository.findUserByCredentials(user.getUsername(), user.getPassword());
        session.setAttribute("profile", profile);
        // if the user profile is found in database,
        // set this profile in the session as the current logged in user
        return profile;
    }

    @PostMapping("/register")
    public User register(HttpSession session,
                         @RequestBody User user) {
        User newUser = userRepository.save(user);
        newUser.setPassword("***");
        session.setAttribute("profile", newUser);
        // once we register a new user in database,
        // set this new user in the session as the current logged in user
        return newUser;
    }

    @PostMapping("/profile")
    public User profile(HttpSession session) {
        User profile = (User)session.getAttribute("profile");
        // return the profile of the current logged in user
        return profile;
    }


}
