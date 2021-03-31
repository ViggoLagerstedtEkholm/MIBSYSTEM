package com.mibsystem.demo.Models;

import com.mibsystem.demo.Models.Actors.Alien;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public abstract class Housing {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Alien alien;

    private transient Vector2D dimensions;
    private int license;
    private String address;

    private double area;
    private int rent;

    public Alien getAlien() {
        return alien;
    }

    public void setAlien(Alien Alien) {
        this.alien = Alien;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public void setDimensions(Vector2D dimensions) {
        this.dimensions = dimensions;
    }

    public Vector2D getDimensions() {
        return dimensions;
    }

    public double getArea() {
        return area;
    }

    public int getRent(){
        return this.rent;
    }

    public void setSize(Vector2D dimensions) {
        this.dimensions = dimensions;
    }

    public int getLicense() {
        return license;
    }

    public void setLicense(int license) {
        this.license = license;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double calculateArea() {
        return dimensions.getX() * dimensions.getY();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}