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
        DayOfWeek scheduleDay = schedule.getDay();
        if (!dayOfWeek.equals(scheduleDay)) {
            return false;
        }
        return !schedule.getStartHour().isBefore(openingTime) && !schedule.getEndHour().isAfter(closingTime);
    }

    public boolean isAvailable(Schedule schedule) {
        DayOfWeek scheduleDay = schedule.getDay();
        LocalTime scheduleStartTime = schedule.getStartHour();
        LocalTime scheduleEndTime = schedule.getEndHour();

        boolean isDayAvailable = dayOfWeek.equals(scheduleDay);
        boolean isTimeWithinRange = !scheduleStartTime.isBefore(this.openingTime) && !scheduleEndTime.isAfter(this.closingTime);

        return isDayAvailable && isTimeWithinRange;
    }


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