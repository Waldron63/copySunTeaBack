package edu.eci.cvds.labReserves.services;
import edu.eci.cvds.labReserves.repository.mongodb.*;
import edu.eci.cvds.labReserves.model.*;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaboratoryService{
    private LaboratoryMongoRepository laboratoryRepo;
    @Autowired
    public LaboratoryService(LaboratoryMongoRepository laboratoryRepo){
        this.laboratoryRepo = laboratoryRepo;
    }

    public void createLaboratory(){
        LaboratoryMongoRepository.save();
    }
}