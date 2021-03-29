package com.mibsystem.demo.Models;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
public class Alien {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @OneToMany(mappedBy = "alien")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private List<Housing> housing = new ArrayList<>();

    @ManyToOne
    private Agent agent;

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    private String name;
    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public List<Housing> getHousing() {
        return housing;
    }

    public void setHousing(List<Housing> housing) {
        this.housing = housing;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public void setAe(int ae) {
        this.age = ae;
    }
}