package com.example.cs5610finalprojectserver.controllers;

import com.example.cs5610finalprojectserver.models.User;
import com.example.cs5610finalprojectserver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
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
        return profile;
    }

    @PostMapping("/register")
    public User register(HttpSession session,
                         @RequestBody User user) {
        // invalidate the register if the same username is already present
        if (userRepository.findUserByUsername(user.getUsername()) != null) {
            return null;
        }
        // otherwise create a new record in database
        User newUser = userRepository.save(user);
        //newUser.setPassword("***");
        // set new user as the current user in session
        session.setAttribute("profile", newUser);
        return newUser;
    }

    @PostMapping("/profile")
    // return current user's profile
    public User profile(HttpSession session) {
        User profile = (User)session.getAttribute("profile");
        return profile;
    }


    @PutMapping("/api/profiles/{pid}")
    public Integer updateProfile(
        HttpSession session, @PathVariable("pid") Integer pid, @RequestBody User newProfile) {
        // newProfile is sent from client
        Optional profileO = userRepository.findById(pid);
        if (profileO.isPresent()) {
            // must update and save the profile retrieved from database
            User profile = (User) profileO.get();

            // check whether the new username causes any conflict in database
            String newUsername = newProfile.getUsername();
            if (!(profile.getUsername().equals(newUsername)) &&
                userRepository.findUserByUsername(newUsername) != null)
                return 0;

            profile.setUsername(newProfile.getUsername());
            profile.setPassword(newProfile.getPassword());
            profile.setEmail(newProfile.getEmail());
            newProfile = userRepository.save(profile);
            // register the updated profile to the session
            session.setAttribute("profile", newProfile);
            return 1;
        }
        return 0;
    }

}
