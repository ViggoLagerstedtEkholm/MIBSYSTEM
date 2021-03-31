package com.mibsystem.demo.Models.Actors;

import com.mibsystem.demo.Models.Equipment;
import com.mibsystem.demo.Models.Housing;
import com.mibsystem.demo.Models.Objective;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
public class Agent extends User {
    @ManyToOne
    private Admin admin;

    @OneToMany(mappedBy="agent")
    private List<Alien> aliens = new ArrayList<>();

    @OneToMany(mappedBy="agent")
    private List<Objective> objectives = new ArrayList<>();

    @OneToMany(mappedBy="agent")
    private List<Equipment> equipment = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private Housing house;

    public void addObjective(Objective objective){
        this.objectives.add(objective);
    }

    public Objective getObjective(int index){
        return this.objectives.get(index);
    }

    public void addAgent(Alien alien){
        this.aliens.add(alien);
    }

    public Alien getAgent(int index) {
        return this.aliens.get(index);
    }

    public List<Alien> getAliens() {
        return aliens;
    }

    public void setAliens(ArrayList<Alien> aliens) {
        this.aliens = aliens;
    }

    public List<Objective> getObjectives() {
        return objectives;
    }

    public void setObjectives(ArrayList<Objective> objectives) {
        this.objectives = objectives;
    }

    public void setAliens(List<Alien> aliens) {
        this.aliens = aliens;
    }

    public void setObjectives(List<Objective> objectives) {
        this.objectives = objectives;
    }

    public Housing getHouse() {
        return house;
    }

    public void setHouse(Housing house) {
        this.house = house;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}