package edu.eci.cvds.labReserves.model;

public class LabReserveException extends Exception{

    public static final String MESSAGE = "Lab Reserve Exception";

    public LabReserveException(String message){
        super(message);
    }
}
