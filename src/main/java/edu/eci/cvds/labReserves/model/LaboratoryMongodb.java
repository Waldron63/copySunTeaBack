package edu.eci.cvds.labReserves.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "laboratory")
public class LaboratoryMongodb extends Laboratory{

    @Id
    private String name;

    public LaboratoryMongodb() {
        super();
    }

}
