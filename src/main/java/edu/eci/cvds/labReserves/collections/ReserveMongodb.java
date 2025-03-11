package edu.eci.cvds.labReserves.collections;

import edu.eci.cvds.labReserves.model.LabReserveException;
import edu.eci.cvds.labReserves.model.Reserve;
import edu.eci.cvds.labReserves.model.Schedule;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * ReserveMongodb class specifically for MongoDB persistence.
 * This class maps to the "reserves" collection in MongoDB.
 */
@Document(collection = "reserve")
public class ReserveMongodb extends Reserve {
    @Id
    private int id; //id of reserve (autogenerate)

    @DBRef
    private int schedule_id; //id of its schedule
    @DBRef
    private int user_id; //id of user that made it

    /**
     * Constructs a ReserveMongodb instance based on a Schedule object.
     *
     * @param reserve the Reserve object to copy properties from
     */
    public ReserveMongodb(Reserve reserve) throws LabReserveException {
        super(reserve.getType(), reserve.getReason(), reserve.getUser());
        this.user_id = reserve.getUser().getId();
        this.schedule_id = reserve.getSchedule().getId();
    }

    /**
     * Gets the id time of the reserve.
     * @return The id
     */
    public int getId(){
        return id;
    }

    /**
     * Gets the Schedule id of reserve.
     * @return The id of its schedule
     */
    public int getScheduleId(){
        return schedule_id;
    }

    /**
     * Gets the user id of reserve.
     * @return The id of its user
     */
    public int getUserId(){
        return user_id;
    }
}
