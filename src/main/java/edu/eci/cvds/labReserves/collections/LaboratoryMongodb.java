package edu.eci.cvds.labReserves.collections;

import edu.eci.cvds.labReserves.model.Laboratory;
import edu.eci.cvds.labReserves.model.Resource;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

import edu.eci.cvds.labReserves.model.ScheduleReference;


/**
 * LaboratoryMongodb class specifically for MongoDB persistence.
 * This class maps to the "laboratories" collection in MongoDB.
 */
@Document(collection = "laboratory")
public class LaboratoryMongodb extends Laboratory {

    private String name; //name of laboratory
    private String abbreviation; //abreviation of laboratory
    private int totalCapacity; //total of chairs for students inside the laboratory
    private String location; //what's the build and floor of laboratory
    private List<Resource> resources; //list of resources (physical and software)
    private List<ScheduleReference> scheduleReferences;

    /**
     * Constructs a LaboratoryMongodb instance based on a Schedule object.
     */
    public LaboratoryMongodb() {
        super();
    }
}
