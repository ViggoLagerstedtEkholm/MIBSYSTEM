package com.mibsystem.demo.Controllers;

import com.mibsystem.demo.Models.Actors.Alien;
import com.mibsystem.demo.Repository.AlienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/alien")
public class AlienController {
    @Autowired
    private AlienRepository alienRepository;

    @RequestMapping(value="/id/{id}", method = RequestMethod.GET)
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public @ResponseBody Alien getAlien(@PathVariable Long id) {
        if(alienRepository.findById(id).isPresent()){
            Alien alien = alienRepository.findById(id).get();
            System.out.print("Found alien.");
            return alien;
        }
        System.out.print("Did not find alien.");

        return null;
    }

    @PostMapping(path="/deleteAll")
    public @ResponseBody void deleteAllAlien () {
        alienRepository.deleteAll();
    }

    @GetMapping(path="/count")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public @ResponseBody int getCount() {
        return (int) alienRepository.count();
    }

    @GetMapping(path="/name/{email}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public @ResponseBody Boolean deleteAccount(@RequestParam String email) {
        Optional<Alien> alien = alienRepository.findByEmail(email);
        boolean hasDeleted = false;
        if(alien.isPresent()){
            Alien alienObject = alien.get();
            alienRepository.delete(alienObject);
            hasDeleted = true;
        }

        return hasDeleted;
    }

    @GetMapping(path="/all")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public @ResponseBody Iterable<Alien> getAllAliens() {
        return alienRepository.findAll();
    }
}