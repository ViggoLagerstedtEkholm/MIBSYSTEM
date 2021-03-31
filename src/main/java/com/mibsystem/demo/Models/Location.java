package com.mibsystem.demo.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
class Location {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Report report;

    private double latitude;
    private double longitude;
    private double altitude;
    private double accuracy;
    private String address;

    public Report getReport() { return report; }

    public void setReport(Report report) { this.report = report; }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public String getAddress() {
        return address;
    }

    public void setId(Long id) { this.id = id; }

    public Long getId() { return id; }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}