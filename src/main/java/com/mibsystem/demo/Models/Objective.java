package com.mibsystem.demo.Models;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class Objective {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Location location;

    @ManyToOne
    private User agent;

    @OneToOne
    private Severity severity;

    private String name;

    public User getAgent() {
        return agent;
    }

    public void setAgent(User agent) {
        this.agent = agent;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location cities) {
        this.location = cities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}