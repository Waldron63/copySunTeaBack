package edu.eci.cvds.labReserves.model;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalTime;

public class ScheduleReference {
    
    private LocalTime openingTime;
    private LocalTime closingTime;
    private DayOfWeek dayOfWeek;
    //private List<Schedule> reservedTimes;

    public ScheduleReference() {
        this.openingTime = null;
        this.closingTime = null;
        this.dayOfWeek = null;
        //this.reservedTimes = new ArrayList<>();
    }
    
    
    public ScheduleReference(DayOfWeek dayOfWeek, LocalTime openingTime, LocalTime closingTime) {
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.dayOfWeek = dayOfWeek;
        //this.reservedTimes = new ArrayList<>();
    }




    public boolean isWithinSchedule(Schedule schedule) {
        DayOfWeek scheduleDay = schedule.getDay().getDayOfWeek();
        if (!dayOfWeek.equals(scheduleDay)) {
            return false;
        }
        return !schedule.getStartHour().isBefore(openingTime) && !schedule.getEndHour().isAfter(closingTime);
    }

    public boolean isAvailable(Schedule schedule) {
        DayOfWeek scheduleDay = schedule.getDay().getDayOfWeek();
        LocalTime scheduleStartTime = schedule.getStartHour();
        LocalTime scheduleEndTime = schedule.getEndHour();

        boolean isDayAvailable = dayOfWeek.equals(scheduleDay);
        boolean isTimeWithinRange = !scheduleStartTime.isBefore(this.openingTime) && !scheduleEndTime.isAfter(this.closingTime);

        return isDayAvailable && isTimeWithinRange;
    }


    /*
    
    public boolean isWithinOperatingHours(Schedule schedule) {

        boolean dayAvailable = availableDays.contains(schedule.getDay());
    
        if (!dayAvailable) {
            return false;
        }
        
        return !schedule.getStartHour().before(openingTime) && 
               !schedule.getEndHour().after(closingTime);
    }
    

    public boolean isTimeSlotAvailable(Schedule schedule) {
        if (!isWithinOperatingHours(schedule)) {
            return false;
        }

        if (!availableDays.contains(schedule.getDay())) {
            return false;
        }

        // overlaps sirve para ver si dos horarios chocan
        
        for (Schedule reserved : reservedTimes) {
            if (reserved.overlaps(schedule)) {
                return false;
            }
        }
        
        return true;
    }

    public boolean overlaps(Schedule other) {
        if (!isSameDay(this.day, other.day)) {
            return false;
        }
        
        return !(this.endHour.before(other.startHour) || 
                 this.startHour.after(other.endHour));
    }
    
    
    public boolean addReservedTimeSlot(Schedule schedule) {
        if (isTimeSlotAvailable(schedule)) {
            reservedTimes.add(schedule);
            return true;
        }
        return false;
    }

    public boolean removeReservedTimeSlot(Schedule schedule) {
        return reservedTimes.remove(schedule);
    }
    
    public void addAvailableDay(Date day) {
        if (!availableDays.contains(day)) {
            availableDays.add(day);
        }
    }
    */



    // Getters y setters
    
    public LocalTime getOpeningTime() {
        return openingTime;
    }
    
    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }
    
    public LocalTime getClosingTime() {
        return closingTime;
    }
    
    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }
    
    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }
    
    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
    
    /*public List<Schedule> getreservedTimes() {
        return reservedTimes;
    }
    
    public void setreservedTimes(List<Schedule> reservedTimes) {
        this.reservedTimes = reservedTimes;
    }

    public void addAvailableDay(DayOfWeek day) {
        if (!dayOfWeek.contains(day)) {
            dayOfWeek.add(day);
        }
    }
        */
}