package edu.eci.cvds.labReserves.collections;
import edu.eci.cvds.labReserves.model.LabReserveException;
import edu.eci.cvds.labReserves.model.Schedule;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * ScheduleMongodb class specifically for MongoDB persistence.
 * This class maps to the "schedules" collection in MongoDB.
 */
@Document(collection = "schedule")
public class ScheduleMongodb extends Schedule {

    @Id
    private int id; //identifier for the scheduleMongodb (auto-generated).

    /**
     * Default constructor for ScheduleMongodb.
     */
    public ScheduleMongodb() {
        super();
    }

    /**
     * Constructs a ScheduleMongodb instance based on a Schedule object.
     *
     * @param schedule the Schedule object to copy properties from
     */
    public ScheduleMongodb(Schedule schedule) throws LabReserveException {
        super(schedule.getStartHour(), schedule.getNumberDay(),
                schedule.getDay(), schedule.getMonth(), schedule.getYear(), schedule.getLaboratory());
        this.id = schedule.getId();
    }

    /**
     * Retrieves the schedule ID.
     *
     * @return The schedule ID.
     */
    @Override
    public int getId() {
        return id;
    }
}
