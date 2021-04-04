package com.mibsystem.demo.Controllers;

import com.mibsystem.demo.Models.Equipment;
import com.mibsystem.demo.Models.User;
import com.mibsystem.demo.Repository.EquipmentRepository;
import com.mibsystem.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Equipment")
public class EquipmentController {
    @Autowired
    private EquipmentRepository equipmentRepository;
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/redeemEquipment/{id}") // Map ONLY POST Requests
    public @ResponseBody
    void redeemEquipment(@PathVariable int id) {
        Optional<Equipment> equipment = equipmentRepository.findById(id);
        if(equipment.isPresent()){
            Equipment equipmentModel = equipment.get();
            equipmentModel.setRented(false);
            equipmentRepository.save(equipmentModel);
        }
    }

    @PostMapping(path="/register/{id/{equipment}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public @ResponseBody String registerEquipment (@RequestParam("id") Long id,@RequestParam("equipment") List<Equipment> equipments) {

        Optional<User> user = userRepository.findById(id);
        if(user != null && user.isPresent()){
            User equipmentUser = user.get();
            equipmentUser.setEquipment(equipments);
            userRepository.save(equipmentUser);
        }

        return "Registered equipments!";
    }

    @PostMapping(path="/ban/{id}/")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public @ResponseBody String banEquipment (@RequestParam Long id) {
        boolean exists = equipmentRepository.existsById(id);
        if(exists){
            Optional<Equipment> equipment = equipmentRepository.findById(id);
            if(equipment.isPresent()){
                Equipment equipmentToDelete = equipment.get();
                if(!equipmentToDelete.isBanned()){
                    equipmentToDelete.setBanned(true);
                    equipmentRepository.save(equipmentToDelete);
                }else{
                    return "Equipment already banned!";
                }
            }
        }else{
            return "Equipment does not exist!";
        }
        return "Registered equipment!";
    }

    @PostMapping(path="/ban/{id}/")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public @ResponseBody String deleteEquipment (@RequestParam Long id) {
        boolean exists = equipmentRepository.existsById(id);
        if(exists){
            Optional<Equipment> equipment = equipmentRepository.findById(id);
            if(equipment.isPresent()){
                Equipment equipmentToDelete = equipment.get();
                equipmentRepository.delete(equipmentToDelete);
                equipmentRepository.save(equipmentToDelete);
            }
        }else{
            return "Equipment does not exist!";
        }
        return "Registered equipment!";
    }
}
