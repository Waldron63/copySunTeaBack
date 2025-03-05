package edu.eci.cvds.labReserves.model;

public class LabReserveException extends Exception{
    //CONSTRUCTOR RESERVE
    public static final String TYPE_RESERVE_NOT_FOUND = "type reserve not found";
    public static final String REASON_RESERVE_NOT_FOUND = "reason reserve not found";
    public static final String USER_RESERVE_NOT_FOUND = "user reserve not found";

    public LabReserveException(String message){
        super(message);
    }
}
