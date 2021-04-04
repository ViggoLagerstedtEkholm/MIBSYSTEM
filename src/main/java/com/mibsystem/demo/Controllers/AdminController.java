package com.mibsystem.demo.Controllers;

import com.mibsystem.demo.Models.Role;
import com.mibsystem.demo.Models.Roles;
import com.mibsystem.demo.Models.User;
import com.mibsystem.demo.Repository.EquipmentRepository;
import com.mibsystem.demo.Repository.RoleRepository;
import com.mibsystem.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @PostMapping(path="/add/{id}")
    public @ResponseBody String addNewAdmin(@RequestParam("name") Long id) {
        Role ADMIN_ROLE = roleRepository.findByName(Roles.ROLE_ADMIN)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        Role USER_ROLE = roleRepository.findByName(Roles.ROLE_ALIEN)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        List<Role> roles = new ArrayList<>();
        roles.add(ADMIN_ROLE);

        Optional<User> User = userRepository.findById(id);
        if(User.isPresent()){
            User UserModel = User.get();
            UserModel.setRoles((Set<Role>) roles);
            userRepository.save(UserModel);
        }
        return "Saved";
    }

    @PostMapping(path="/remove/{id}")
    public @ResponseBody String removeAdmin(@RequestParam("name") Long id) {
        Role ADMIN_ROLE = roleRepository.findByName(Roles.ROLE_ADMIN)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        Role User_ROLE = roleRepository.findByName(Roles.ROLE_ALIEN)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        List<Role> roles = new ArrayList<>();
        roles.add(ADMIN_ROLE);
        roles.add(User_ROLE);

        Optional<User> User = userRepository.findById(id);
        if(User.isPresent()){
            User UserModel = User.get();
            UserModel.setRoles((Set<Role>) roles);
            userRepository.save(UserModel);
        }
        return "Saved";
    }
}
