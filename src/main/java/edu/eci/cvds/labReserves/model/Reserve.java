package edu.eci.cvds.labReserves.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;

/**
 * The Reserve class represents a reservation for a laboratory made by a user with a specific schedule.
 * It defines the type, state, and reason for the reservation.
 */
public class Reserve {

    private static String[] typeReserve = new String[] {"lesson","available"}; //types of reserves
    private static String[] stateReserve = new String[] {"reserved","occupied","free"}; //states of reserves
    private String type; //type of this reserve at moment
    private String reason; //reason why this reserve was created
    private String state; //state of this reserve at moment
    private User user; //user who create it
    private Schedule schedule; //schedule for this reserve

    /**
     * Constructs a Reserve object with a specified type, reason, and user.
     * @param type   The type of the reserve
     * @param reason The reason for the reserve
     * @param user   The user who created the reserve
     * @throws LabReserveException If any parameter is invalid
     */
    public Reserve(String type, String reason, User user) throws LabReserveException {
        if (!Arrays.asList(typeReserve).contains(type)) {
            throw new LabReserveException(LabReserveException.TYPE_RESERVE_NOT_FOUND);
        }else if (reason.isEmpty()) {
            throw new LabReserveException(LabReserveException.REASON_RESERVE_NOT_FOUND);
        } else if (user == null) {
            throw new LabReserveException(LabReserveException.USER_RESERVE_NOT_FOUND);
        }
        this.type = type;
        this.reason = reason;
        this.user = user;
        this.state = "reserved";
    }

    /**
     * Sets the schedule for this reserve.
     * @param startHour The start time of the schedule
      * @param numberDay The day of the month
      * @param day       The day of the week
      * @param month     The month of the year
      * @param year      The year of the schedule
      * @throws LabReserveException If the provided values are invalid
     */
    public void setSchedule(LocalTime startHour, int numberDay, DayOfWeek day, Month month, int year)
            throws LabReserveException {
        this.schedule = new Schedule();
        schedule.setYear(year);
        schedule.setMonth(month);
        schedule.setNumberDay(numberDay);
        schedule.setDay(day);
        schedule.setStartHour(startHour);
    }

    /**
     * Sets the reason for the reserve.
     * @param reason The new reason for the reserve
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * Sets the user for the reserve.
     * @param user The user who created the reserve
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Sets the state of the reserve.
     * @param state The new state of the reserve
     * @throws LabReserveException If the state is invalid
     */
    public void setState(String state) throws LabReserveException {
        if (Arrays.asList(stateReserve).contains(state)) {
            this.state = state;
        } else {
            throw new LabReserveException(LabReserveException.STATE_RESERVE_NOT_FOUND);
        }
    }

    /**
     * Sets the type of the reserve.
     * @param type The new type of the reserve
     * @throws LabReserveException If the type is invalid
     */
    public void setType(String type) throws LabReserveException {
        if (Arrays.asList(typeReserve).contains(type)) {
            this.type = type;
        }else {
            throw new LabReserveException(LabReserveException.TYPE_RESERVE_NOT_FOUND);
        }
    }

    /**
     * Gets the type of the reserve.
     * @return The type of the reserve
     */
    public String getType() { return type; }

    /**
     * Gets the reason for the reserve.
     * @return The reason for the reserve
     */
    public String getReason() { return reason; }

    /**
     * Gets the current state of the reserve.
     * @return The current state of the reserve
     */
    public String getState() { return state; }

    /**
     * Gets the user who created the reserve.
     * @return The user who created the reserve
     */
    public User getUser() { return user; }

    /**
     * Gets the schedule associated with this reserve.
     * @return The schedule of the reserve
     */
    public Schedule getSchedule() { return schedule; }
}
