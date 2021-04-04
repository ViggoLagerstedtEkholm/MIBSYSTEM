package com.mibsystem.demo.Controllers;

import com.mibsystem.demo.Models.Housing;
import com.mibsystem.demo.Repository.HosingRepository;
import com.mibsystem.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Equipment")
public class HousingController {
    @Autowired
    private HosingRepository hosingRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/register/{id/{housing}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public @ResponseBody String registerHosuing (@RequestParam("id") Long id,@RequestParam("equipment") Housing housing) {

        return "Registered hosuing!";
    }

}
