package com.mibsystem.demo.Controllers;

import com.mibsystem.demo.Models.User;
import com.mibsystem.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/alien")
public class AlienController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/deleteAll")
    public @ResponseBody void deleteAllAlien () {
        userRepository.deleteAll();
    }

    @GetMapping(path="/count")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public @ResponseBody int getCount() {
        return (int) userRepository.count();
    }

    @GetMapping(path="/all")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public @ResponseBody Iterable<User> getAllAliens() {
        return userRepository.findAll();
    }
}