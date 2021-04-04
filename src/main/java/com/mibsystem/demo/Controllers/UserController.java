package com.mibsystem.demo.Controllers;

import com.mibsystem.demo.Models.Role;
import com.mibsystem.demo.Models.Roles;
import com.mibsystem.demo.Models.User;
import com.mibsystem.demo.Repository.RoleRepository;
import com.mibsystem.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @RequestMapping(value="/get/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public @ResponseBody User getUser(@PathVariable Long id) {
        if(userRepository.findById(id).isPresent()){
            User alien = userRepository.findById(id).get();
            System.out.print("Found user.");
            return alien;
        }
        System.out.print("Did not find user.");

        return null;
    }

    @RequestMapping(value="/get/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public @ResponseBody Boolean removeUser(@PathVariable Long id, @AuthenticationPrincipal User loggedInUser) {
        if(userRepository.findById(id).isPresent()){
            User user = userRepository.findById(id).get();
            if(user.getRoles().contains(Roles.ROLE_ADMIN)){
                if(loggedInUser.getRoles().contains(Roles.ROLE_ADMIN)){
                    userRepository.delete(user);
                    userRepository.save(user);
                    System.out.print("Found user.");
                }else{
                    return false;
                }
            }else{
                userRepository.delete(user);
                userRepository.save(user);
            }
        }
        System.out.print("Did not find user.");
        return false;
    }

    @RequestMapping(value="/get/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public @ResponseBody Boolean addAdmin(@PathVariable Long id) {
        if(userRepository.findById(id).isPresent()){
            Set<Role> roles = new HashSet<>();
            User user = userRepository.findById(id).get();
            Role userRole = roleRepository.findByName(Roles.ROLE_ALIEN)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
            user.setRoles(roles);
            System.out.print("Found user.");
            return true;
        }
        System.out.print("Did not find user.");

        return false;
    }

    @RequestMapping(value="/get/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public @ResponseBody Boolean removeAdmin(@PathVariable Long id) {
        if(userRepository.findById(id).isPresent()){
            Set<Role> roles = new HashSet<>();
            User user = userRepository.findById(id).get();
            Role userRole = roleRepository.findByName(Roles.ROLE_AGENT)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
            user.setRoles(roles);
            System.out.print("Found user.");
            return true;
        }
        System.out.print("Did not find user.");

        return false;
    }


    @GetMapping(path="/count")
    public @ResponseBody int getCount(){
        return (int) userRepository.count();
    }
}
