package com.mibsystem.demo.Models;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class Equipment
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private int weight;
    private String name;
    private boolean isRented;
    private boolean isBanned;

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}