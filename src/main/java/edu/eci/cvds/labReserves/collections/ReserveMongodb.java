package edu.eci.cvds.labReserves.collections;

import edu.eci.cvds.labReserves.model.Reserve;
import edu.eci.cvds.labReserves.model.Schedule;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reserve")
public class ReserveMongodb extends Reserve {
    @Id
    private int id;
    private String type;
    private String reason;
    private String state;
    private String user;
    @DBRef
    private int schedule_id;
    @DBRef
    private int user_id;

    public ReserveMongodb() {
        super();
    }

    public String getType(){
        return super.getType();
    }
    public String getReason(){
        return super.getReason();
    }
    public void setReason(String reason){
        super.setReason(reason);
    }
    public String getState(){
        return super.getState();
    }
    public void setState(String state){
        super.setState(state);
    }
    public String getUser(){
        return super.getUser();
    }
    public Schedule getSchedule(){
        return super.getSchedule();
    }
    public void setSchedule(String day, String startHour, String nameLaboratory){
        super.setSchedule(day,startHour,nameLaboratory);
    }
}
