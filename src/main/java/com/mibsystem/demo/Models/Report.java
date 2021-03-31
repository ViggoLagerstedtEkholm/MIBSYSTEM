package com.mibsystem.demo.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class Report {
    @Id
    private Long Id;
    private Date date;
    private String subject;
    private String message;

    @OneToOne
    private Location location;

    public void setId(Long id) {
        this.Id = id;
    }

    public Long getId() {
        return Id;
    }
}
