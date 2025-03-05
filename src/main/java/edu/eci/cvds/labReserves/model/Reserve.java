package edu.eci.cvds.labReserves.model;

import java.util.Arrays;

public class Reserve {

    private static String[] typeReserve = new String[] {"lesson","available"};
    private static String[] stateReserve = new String[] {"reserved","occupied","free"};
    private String type;
    private String reason;
    private String state;
    private String user;
    private Schedule schedule;

    public Reserve(String reason, String user) throws LabReserveException {
    if (reason.isEmpty()) {
        throw new LabReserveException(LabReserveException.REASON_RESERVE_NOT_FOUND);
    } else if (user.isEmpty()) {
        throw new LabReserveException(LabReserveException.USER_RESERVE_NOT_FOUND);
    }
        this.type = "available";
        this.reason = reason;
        this.user = user;
        this.state = "reserved";
    }

    public Reserve(String type, String reason, String user) throws LabReserveException {
        if (Arrays.asList(typeReserve).contains(type)) {
            throw new LabReserveException(LabReserveException.TYPE_RESERVE_NOT_FOUND);
        }else if (reason.isEmpty()) {
            throw new LabReserveException(LabReserveException.REASON_RESERVE_NOT_FOUND);
        } else if (user.isEmpty()) {
            throw new LabReserveException(LabReserveException.USER_RESERVE_NOT_FOUND);
        }
        this.type = type;
        this.reason = reason;
        this.user = user;
        this.state = "reserved";
    }

    public void setSchedule(String day, String startHour, String endHour){
        this.schedule = new Schedule();
        schedule.setDay(day);
        schedule.setStartHour(startHour);
        schedule.setEndHour(endHour);
    }

    public void deleteReserve(){
        return;
    }

    public void extendReserve(){
        return;
    }

    public String getType() {
        return type;
    }
    public String getReason() { return reason; }
    public String getState() { return state; }
    public String getUser() { return user; }
    public Schedule getSchedule() { return schedule; }
}
