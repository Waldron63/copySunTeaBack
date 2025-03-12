package edu.eci.cvds.labReserves.collections;
import edu.eci.cvds.labReserves.model.Laboratory;
import edu.eci.cvds.labReserves.model.Resource;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import edu.eci.cvds.labReserves.model.ScheduleReference;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "laboratory")
public class LaboratoryMongodb extends Laboratory {

    @Field("name")
    private String name;
    
    @Field("abbreviation")
    private String abbreviation;
    
    @Field("totalCapacity")
    private int totalCapacity;
    
    @Field("location")
    private String location;
    
    @Field("resources")
    private List<Resource> resources;
    
    @Field("scheduleReferences")
    private List<ScheduleReference> scheduleReferences;

    public LaboratoryMongodb(Laboratory laboratory) {
        super(laboratory.getName(), laboratory.getAbbreviation(), laboratory.getTotalCapacity(), laboratory.getLocation(), laboratory.getScheduleReferences());
    }
    
}