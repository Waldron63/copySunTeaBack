package edu.eci.cvds.labReserves.collections;
import edu.eci.cvds.labReserves.model.Laboratory;
import edu.eci.cvds.labReserves.model.Resource;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "laboratory")
public class LaboratoryMongodb extends Laboratory {

    private String name;
    private String abbreviation;
    private int totalCapacity;
    private String location;
    private List<Resource> resources;
    private List<ScheduleReference> scheduleReferences;


    public LaboratoryMongodb() {
        super();
    }
    public String getName(){
        return super.getName();
    }
    public void setName(String name){
        super.setName(name);
    }
    public String getAbbreviation(){
        return super.geAbbreviation();
    }
    public void setAbbreviation(String abbreviation){
        super.setAbbreviation(abbreviation);
    }
    public int getTotalCapacity(){
        return super.getTotalCapacity();
    }
    public void setTotalCapacity(int totalCapacity){
        super.setName(totalCapacity);
    }
    public String getLocation(){
        return super.getLocation();
    }
    public void setLocation(String location){
        super.setLocation(location);
    }
}

