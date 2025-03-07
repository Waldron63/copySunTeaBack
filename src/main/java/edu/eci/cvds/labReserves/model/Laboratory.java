package edu.eci.cvds.labReserves.model;

import java.util.ArrayList;
import java.util.List;

public class Laboratory {

    private String abbreviation;
    private String name;
    private int totalCapacity;
    private String location;

    public Laboratory(String name, String abbreviation, int totalCapacity, String location) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.totalCapacity = totalCapacity;
        this.location = location;
    }
    
    // Getters y setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getAbbreviation() {
        return abbreviation;
    }
    
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    
    public int getTotalCapacity() {
        return totalCapacity;
    }
    
    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public List<Physical> getPhysicalResources() {
        return physicalResources;
    }
    
    public void setPhysicalResources(List<Physical> physicalResources) {
        this.physicalResources = physicalResources;
    }
    
    public List<Software> getSoftwareResources() {
        return softwareResources;
    }
    
    public void setSoftwareResources(List<Software> softwareResources) {
        this.softwareResources = softwareResources;
    }


}
