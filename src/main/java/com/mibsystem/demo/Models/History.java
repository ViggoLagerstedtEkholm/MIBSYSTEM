package com.mibsystem.demo.Models;

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
    private User agent;

    public History() {}

    public void setId(Long Id) {
        this.Id = Id;
    }


    public Long getId() {
        return Id;
    }
}
