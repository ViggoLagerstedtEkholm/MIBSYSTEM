package com.mibsystem.demo.Controllers;

import com.mibsystem.demo.Models.Actors.Admin;
import com.mibsystem.demo.Models.Actors.Agent;
import com.mibsystem.demo.Models.Actors.User;
import com.mibsystem.demo.Models.Role;
import com.mibsystem.demo.Models.Roles;
import com.mibsystem.demo.Repository.AgentRepository;
import com.mibsystem.demo.Repository.AlienRepository;
import com.mibsystem.demo.Repository.EquipmentRepository;
import com.mibsystem.demo.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Admin")
public class AdminController {
    @Autowired
    private AgentRepository agentRepository;
    @Autowired
    private EquipmentRepository equipmentRepository;
    @Autowired
    private AlienRepository alienRepository;
    @Autowired
    private RoleRepository roleRepository;

    @PostMapping(path="/add/{id}")
    public @ResponseBody
    String addNewAdmin(@RequestParam("name") Integer id) {
        Role ADMIN_ROLE = roleRepository.findByName(Roles.ROLE_ADMIN)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        Role AGENT_ROLE = roleRepository.findByName(Roles.ROLE_AGENT)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        List<Role> roles = new ArrayList<>();
        roles.add(ADMIN_ROLE);
        roles.add(AGENT_ROLE);

        Optional<Agent> agent = agentRepository.findById(id);
        if(agent.isPresent()){
            Agent agentModel = agent.get();
            agentModel.setRoles((Set<Role>) roles);
            agentRepository.save(agentModel);
        }
        return "Saved";
    }

    @PostMapping(path="/remove/{id}")
    public @ResponseBody
    String removeAdmin(@RequestParam("name") Integer id) {
        Role ADMIN_ROLE = roleRepository.findByName(Roles.ROLE_ADMIN)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        Role AGENT_ROLE = roleRepository.findByName(Roles.ROLE_AGENT)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        List<Role> roles = new ArrayList<>();
        roles.add(ADMIN_ROLE);
        roles.add(AGENT_ROLE);

        Optional<Agent> agent = agentRepository.findById(id);
        if(agent.isPresent()){
            Agent agentModel = agent.get();
            agentModel.setRoles((Set<Role>) roles);
            agentRepository.save(agentModel);
        }
        return "Saved";
    }
}
