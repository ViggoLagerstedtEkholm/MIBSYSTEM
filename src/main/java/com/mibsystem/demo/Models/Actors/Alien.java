package com.mibsystem.demo.Models.Actors;
import com.mibsystem.demo.Models.Housing;
import org.hibernate.annotations.Cascade;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
public class Alien extends User{
    @OneToMany(mappedBy = "alien")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private List<Housing> housing = new ArrayList<>();

    @ManyToOne
    private Agent agent;

    public Agent getAgent() {return agent;}

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public List<Housing> getHousing() {
        return housing;
    }

    public void setHousing(List<Housing> housing) {
        this.housing = housing;
    }
}