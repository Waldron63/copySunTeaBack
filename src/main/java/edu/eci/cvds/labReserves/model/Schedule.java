package edu.eci.cvds.labReserves.model;

import java.util.Date;
import java.util.Calendar;
import java.time.LocalDate;
import java.time.LocalTime;

public class Schedule {
    
    private LocalTime startHour;
    private LocalTime endHour;
    private LocalDate day;
    
    public Schedule(LocalDate day, LocalTime startHour, LocalTime endHour) {
        this.day = day;
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public boolean overlaps(Schedule other) {
        if (!this.day.equals(other.day)) {
            return false;
        }
        return (startHour.isBefore(other.endHour) && endHour.isAfter(other.startHour));
    }
    
    
    // Getters y setters
    public LocalTime getStartHour() {
        return startHour;
    }
    
    public void setStartHour(LocalTime startHour) {
        this.startHour = startHour;
    }
    
    public LocalTime getEndHour() {
        return endHour;
    }
    
    public void setEndHour(LocalTime endHour) {
        this.endHour = endHour;
    }
    
    public LocalDate getDay() {
        return day;
    }
    
    public void setDay(LocalDate day) {
        this.day = day;
    }
}