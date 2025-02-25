package edu.eci.cvds.labReserves.model;

import java.util.Date;

public class Schedule {

    private static String[] daySchedule = new String[]
            {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
    private static String[] hours = new String[] {"7:00","8:30","10:00","11:30","1:00","2:30","4:00","5:30"};

    private String startHour;
    private String endHour;
    private String day;
    private Laboratory laboratory;

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }
}
