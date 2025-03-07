package edu.eci.cvds.labReserves.collections;
import edu.eci.cvds.labReserves.model.Schedule;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "schedule")
public class ScheduleMongodb extends Schedule {
    @Id
    private int id;
    private String startHour;
    private String endHour;
    private String day;
    private int laboratory_id;

    public ScheduleMongodb() {
        super();
    }



}
