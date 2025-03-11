package edu.eci.cvds.labReserves.model;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.util.Map;


public class Laboratory {

    private String abbreviation;
    private String name;
    private int totalCapacity;
    private String location;
    private ArrayList<Physical> physicalResources;
    private ArrayList<Software> softwareResources;
    private List<ScheduleReference> scheduleReferences;

    public Laboratory() {
        this.physicalResources = new ArrayList<>();
        this.softwareResources = new ArrayList<>();
        this.scheduleReferences = new ArrayList<>();
    }

    public Laboratory(String name, String abbreviation, int totalCapacity, String location, List<ScheduleReference> scheduleReferences) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.totalCapacity = totalCapacity;
        this.location = location;
        this.physicalResources = new ArrayList<>();
        this.softwareResources = new ArrayList<>();
        this.scheduleReferences = scheduleReferences;
    }

    public boolean validateSchedule(Schedule schedule) {
        DayOfWeek scheduleDay = schedule.getDay().getDayOfWeek();
        for (ScheduleReference ref : scheduleReferences) {
            if (ref.getDayOfWeek().equals(scheduleDay) && ref.isWithinSchedule(schedule)) {
                return true;
            }
        }
        return false;
    }

    public void setReferenceSchedules(Map<DayOfWeek, ScheduleReference> daySchedules) {
        this.scheduleReferences = new ArrayList<>(daySchedules.values());
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

    public void addScheduleReference(ScheduleReference scheduleReference) {
        DayOfWeek day = scheduleReference.getDayOfWeek();
        for (int i = 0; i < scheduleReferences.size(); i++) {
            if (scheduleReferences.get(i).getDayOfWeek().equals(day)) {
                scheduleReferences.set(i, scheduleReference);
                return;
            }
        }
        scheduleReferences.add(scheduleReference);
    }
    

    public void addAvailableDay(DayOfWeek day, LocalTime openingTime, LocalTime closingTime) {
        ScheduleReference reference = new ScheduleReference(day, openingTime, closingTime);
        addScheduleReference(reference);
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
    
    public List<ScheduleReference> getScheduleReferences() {
        return scheduleReferences;
    }
    
    public void setScheduleReferences(List<ScheduleReference> scheduleReferences) {
        this.scheduleReferences = scheduleReferences;
    }

    public ScheduleReference getScheduleReferenceForDay(DayOfWeek day) {
        for (ScheduleReference ref : scheduleReferences) {
            if (ref.getDayOfWeek().equals(day)) {
                return ref;
            }
        }
        return null;
    }


}
