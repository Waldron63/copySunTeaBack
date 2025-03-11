package edu.eci.cvds.labReserves.services;
import edu.eci.cvds.labReserves.repository.mongodb.*;
import edu.eci.cvds.labReserves.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReserveService{
    private ReserveMongoRepository reserveRepo;
    @Autowired
    public ReserveService(ReserveMongoRepository reserveRepo){
        this.reserveRepo = reserveRepo;
    }

    public void saveReserve(Reserve reserve){
        reserveRepo.saveReserve(reserve);
    }

}