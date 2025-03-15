package edu.eci.cvds.labReserves.dto;

import edu.eci.cvds.labReserves.model.User;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.Month;

public class ReserveRequest {

    private String type; //type of this reserve at moment
    private String reason; //reason why this reserve was created
    private String state; //state of this reserve at moment
    private int userId; //id of user that made it

    private LocalTime startHour; //start of resource
    private int numberDay; //number of day that generate resource
    private DayOfWeek day; //day that generate resource
    private Month month; //month that generate resource
    private int year; //year that generate resource

    public String getType() {
        return type;
    }

    public String getReason() {
        return reason;
    }

    public String getState() {
        return state;
    }

    public int getUserId() {
        return userId;
    }

    public LocalTime getStartHour() {
        return startHour;
    }

    public int getNumberDay() {
        return numberDay;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public Month getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
