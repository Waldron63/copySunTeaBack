package edu.eci.cvds.labReserves.model;

public class Reserve {

    private static String[] typeReserve = new String[] {"lesson","available"};
    private static String[] stateReserve = new String[] {"reserved","occupied","free"};
    private String type;
    private String reason;
    private String state;
    private String user;
    private Schedule schedule;

    public Reserve(String type, String reason, String user) {
        this.type = type;
        this.reason = reason;
        this.user = user;
        this.state = "reserved";
    }
}
