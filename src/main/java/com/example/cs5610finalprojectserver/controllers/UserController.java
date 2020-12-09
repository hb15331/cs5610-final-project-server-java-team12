package com.example.cs5610finalprojectserver.controllers;

import com.example.cs5610finalprojectserver.models.User;
import com.example.cs5610finalprojectserver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;


@RestController
//@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class UserController {

    @Autowired
    UserRepository userRepository;


    @PostMapping("/logout")
    public Integer logout(HttpSession session) {
        session.invalidate();
        return 1;
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

    @GetMapping("/api/profiles")
    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }

    @GetMapping("/api/profiles/{pid}")
    public User findUserById(HttpSession session, @PathVariable("pid") Integer pid) {
        Optional profile0 = userRepository.findById(pid);
        if(profile0.isPresent()) {
            User profile = (User) profile0.get();
            return profile;
        }
        return null;
    }

    @GetMapping("/api/profiles/{pid}/deliverers")
    public List<User> findMatchingDeliverers(HttpSession session, @PathVariable("pid") Integer pid) {
        User customer = findUserById(session, pid);
        String location = customer.getLocation();
        String type = "DELIVERER";
        return userRepository.findMatchingDeliverers(location, type);
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
            profile.setLocation(newProfile.getLocation());
            newProfile = userRepository.save(profile);
            // register the updated profile to the session
            session.setAttribute("profile", newProfile);
            return 1;
        }
        return 0;
    }

    @GetMapping("/api/profile/{uid}")
    public User findPublicProfileById(@PathVariable("uid") Integer userId) {
        Optional userO = userRepository.findById(userId);
        if(userO.isPresent()) {
            User publicInfo = (User) userO.get();
            //hide private info
            publicInfo.setPassword("");
            publicInfo.setEmail("");
            publicInfo.setFirstName("");
            publicInfo.setLastName("");
            return publicInfo;
        }
        return null;
        }
}
