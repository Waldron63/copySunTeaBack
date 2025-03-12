package edu.eci.cvds.labReserves.collections;
import edu.eci.cvds.labReserves.model.Laboratory;
import edu.eci.cvds.labReserves.model.Resource;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "laboratory")
public class LaboratoryMongodb extends Laboratory {

    private List<Resource> resources;

    public LaboratoryMongodb() {
        super();
    }
}

