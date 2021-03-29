package com.mibsystem.demo.Models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
public class Agent {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;
    private int age;

    @OneToMany(mappedBy="agent")
    private List<Alien> aliens = new ArrayList<>();

    @OneToMany(mappedBy="agent")
    private List<Objective> objectives = new ArrayList<>();

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
}