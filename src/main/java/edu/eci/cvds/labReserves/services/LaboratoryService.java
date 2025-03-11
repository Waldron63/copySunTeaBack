package edu.eci.cvds.labReserves.services;
import edu.eci.cvds.labReserves.collections.LaboratoryMongodb;
import edu.eci.cvds.labReserves.repository.mongodb.*;
import edu.eci.cvds.labReserves.model.*;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The {@code LaboratoryService} class provides business logic for managing reserves within the application.
 * It handles operations related to reserves, including creating, updating, deleting.
 */
@Service
public class LaboratoryService{
    private LaboratoryMongoRepository laboratoryRepo;

    /**
     * Constructor to inject dependencies for LaboratoryMongoRepository
     *
     * @param laboratoryRepo the laboratory for MongoDB laboratories
     */
    @Autowired
    public LaboratoryService(LaboratoryMongoRepository laboratoryRepo){
        this.laboratoryRepo = laboratoryRepo;
    }

    /**
     * Saves a laboratory .
     *
     * @param lab the laboratory functional currently.
     * @return the saved Laboratory object
     */
    public LaboratoryMongodb createLaboratory(LaboratoryMongodb lab){
        return laboratoryRepo.save(lab);
    }
}