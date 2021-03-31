package com.mibsystem.demo.Models.Actors;

import com.mibsystem.demo.Models.History;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Admin extends User{
    @OneToOne
    private History history;

    @OneToMany(mappedBy="admin")
    private List<Agent> agents = new ArrayList<>();
}
