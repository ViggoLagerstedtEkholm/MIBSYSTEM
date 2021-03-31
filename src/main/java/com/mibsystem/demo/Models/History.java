package com.mibsystem.demo.Models;

import com.mibsystem.demo.Models.Actors.Agent;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class History {
    @Id
    private Long Id;
    private Date deletedDate;

    @OneToOne
    private Agent agent;

    public History() {}

    public void setId(Long Id) {
        this.Id = Id;
    }


    public Long getId() {
        return Id;
    }
}
