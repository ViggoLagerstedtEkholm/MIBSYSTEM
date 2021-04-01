package com.mibsystem.demo.Models.Request;

import java.util.Set;

public class Promotion {
    private int id;
    private int updatedSalary;
    private Set<String> roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUpdatedSalary() {
        return updatedSalary;
    }

    public void setUpdatedSalary(int updatedSalary) {
        this.updatedSalary = updatedSalary;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
