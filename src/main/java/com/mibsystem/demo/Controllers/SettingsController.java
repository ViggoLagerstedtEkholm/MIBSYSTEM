package com.mibsystem.demo.Controllers;

import com.mibsystem.demo.Models.User;
import com.mibsystem.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/settings")
public class SettingsController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path="/delete/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public @ResponseBody Boolean deleteAccount(@RequestParam Long id) {
        Optional<User> alien = userRepository.findbyEmail("test");
        boolean hasDeleted = false;
        if(alien.isPresent()){
            User alienObject = alien.get();
            userRepository.delete(alienObject);
            hasDeleted = true;
        }
        return hasDeleted;
    }

    @GetMapping(path="/change/email/{email}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public @ResponseBody Boolean changeEmail(@RequestParam String email) {
        //TODO
        return false;
    }

    @GetMapping(path="/change/username/{email}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public @ResponseBody Boolean changeUsername(@RequestParam String email) {
        //TODO
        return false;
    }
}
