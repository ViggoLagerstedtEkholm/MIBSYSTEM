package com.mibsystem.demo.Controllers;

import com.mibsystem.demo.Models.Actors.Agent;
import com.mibsystem.demo.Models.Actors.User;
import com.mibsystem.demo.Models.Equipment;
import com.mibsystem.demo.Repository.AgentRepository;
import com.mibsystem.demo.Repository.EquipmentRepository;
import com.mibsystem.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Agent")
public class AgentController {
    @Autowired
    private AgentRepository agentRepository;
    @Autowired
    private EquipmentRepository equipmentRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewAgent(@RequestParam("name") String name, @RequestParam("age") int age) {
        Agent agent = new Agent();
        agent.setAge(age);
        agent.setName(name);
        agentRepository.save(agent);

        return "Saved";
    }

    @PostMapping(path="/rentEquipment/{id}/") // Map ONLY POST Requests
    public @ResponseBody String registerEquipment (@RequestParam int id) {
        boolean exists = equipmentRepository.existsById(id);
        Optional<Agent> agent = agentRepository.findById(id);

        if(exists){
            List<Equipment> equipmentList = new ArrayList<>();
            Equipment equipment = new Equipment();
            equipment.setName("Weapon");
            equipment.setWeight(55);
            equipment.setRented(true);

            equipmentList.add(equipment);
            if(agent.isPresent()){
                Agent agentModel = agent.get();
                agentModel.setEquipment(equipmentList);
                agentRepository.save(agentModel);
            }
            equipmentRepository.save(equipment);
        }else{
            return "Equipment does not exist!";
        }
        return "Registered equipment!";
    }

    @PostMapping(path="/redeemEquipment/{id}/") // Map ONLY POST Requests
    public @ResponseBody void redeemEquipment(@PathVariable int id) {
        Optional<Equipment> equipment = equipmentRepository.findById(id);
        if(equipment.isPresent()){
            Equipment equipmentModel = equipment.get();
            equipmentModel.setRented(false);
            equipmentRepository.save(equipmentModel);
        }
    }

    @GetMapping(path="/count")
    public @ResponseBody int getCount(){
        return (int) agentRepository.count();
    }
}
