package edu.eci.cvds.labReserves.model;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Laboratory {

    private String abbreviation;
    private String name;
    private int totalCapacity;
    private String location;
    private ArrayList<Physical> physicalResources;
    private ArrayList<Software> softwareResources;
    private ScheduleReference scheduleReference;

    public Laboratory() {
        this.physicalResources = new ArrayList<>();
        this.softwareResources = new ArrayList<>();
        this.scheduleReference = new ScheduleReference();
    }

    public Laboratory(String name, String abbreviation, int totalCapacity, String location, ScheduleReference scheduleReference) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.totalCapacity = totalCapacity;
        this.location = location;
        this.physicalResources = new ArrayList<>();
        this.softwareResources = new ArrayList<>();
        this.scheduleReference = scheduleReference;
    }

    public boolean validateSchedule(Schedule schedule) {
        return scheduleReference.isWithinSchedule(schedule);
    }

    public void setReferenceSchedule(List<DayOfWeek> availableDays, LocalTime openingTime, LocalTime closingTime) {
        this.scheduleReference = new ScheduleReference(availableDays, openingTime, closingTime);
    }

    /*public boolean isAvailable(Schedule schedule) {
        return scheduleReference.isTimeSlotAvailable(schedule);
    }

    public boolean reserv(Schedule schedule) {
        return isAvailable(schedule) && scheduleReference.addReservedTimeSlot(schedule);
    }
    
    public boolean cancelReserving(Schedule schedule) {
        return scheduleReference.removeReservedTimeSlot(schedule);
    }
    */
    

    public void addAvailableDay(DayOfWeek day) {
        scheduleReference.addAvailableDay(day);
    }
    


    public void addPhysicalResource(Physical resource) {
        physicalResources.add(resource);
    }
    
    public void removePhysicalResource(Physical resource) {
        physicalResources.remove(resource);
    }
    
    public void addSoftwareResource(Software resource) {
        softwareResources.add(resource);
    }
    
    public void removeSoftwareResource(Software resource) {
        softwareResources.remove(resource);
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
        this.physicalResources = new ArrayList<>(physicalResources);
    }
    
    public List<Software> getSoftwareResources() {
        return softwareResources;
    }
    
    public void setSoftwareResources(List<Software> softwareResources) {
        this.softwareResources = new ArrayList<>(softwareResources);
    }
    
    public ScheduleReference getScheduleReference() {
        return scheduleReference;
    }
    
    public void setScheduleReference(ScheduleReference scheduleReference) {
        this.scheduleReference = scheduleReference;
    }


}
