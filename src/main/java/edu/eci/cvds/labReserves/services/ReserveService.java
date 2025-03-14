package edu.eci.cvds.labReserves.services;
import edu.eci.cvds.labReserves.collections.ReserveMongodb;
import edu.eci.cvds.labReserves.repository.mongodb.*;
import edu.eci.cvds.labReserves.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.List;

/**
 * The {@code ReserveService} class provides business logic for managing reserves within the application.
 * It handles operations related to reserves, including creating, updating, deleting.
 */
@Service
public class ReserveService{

    @Autowired
    private ReserveMongoRepository reserveRepo;

    /**
     * Constructor to inject dependencies for ReserveMongoRepository
     *
     * @param reserveRepo the repository for MongoDB reserves
     */
    public ReserveService(ReserveMongoRepository reserveRepo){
        this.reserveRepo = reserveRepo;
    }

    /**
     * Saves a reserve .
     *
     * @param reserve the reserve made of the user
     * @return the saved Reserve object
     */
    public Reserve saveReserve(Reserve reserve) throws LabReserveException {
        ReserveMongodb resMongo = new ReserveMongodb(reserve);
        return reserveRepo.save(resMongo);
    }

    public void deleteReserveBySchedule() throws LabReserveException {
        //reserveRepo.deleteBySchedule_id();
    }

    public void deleteAllReserveByUser() throws LabReserveException {
        return;
    }

    public List<ReserveMongodb> getAllReserves() throws LabReserveException {
        return reserveRepo.findAll();
    }

    public List<ReserveMongodb> getReserveByLaboratory(String laboratoryName) throws LabReserveException {
        return null;
    }

    public ReserveMongodb getReserveByUser(String user_id) throws LabReserveException {
        return null;
    }

    public List<ReserveMongodb> getReserveByDay(DayOfWeek day) throws LabReserveException {
        return null;
    }

}