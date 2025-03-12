package edu.eci.cvds.labReserves.services;
import edu.eci.cvds.labReserves.collections.ReserveMongodb;
import edu.eci.cvds.labReserves.repository.mongodb.*;
import edu.eci.cvds.labReserves.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.ArrayList;
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

    public void deleteReserveBySchedule(Schedule schedule) throws LabReserveException {
        reserveRepo.deleteBySchedule(schedule);
    }

    public void deleteAllReserveByUser(String userId) throws LabReserveException {
        reserveRepo.deleteAllByUserId(userId);
    }

    public List<ReserveMongodb> getAllReserves() throws LabReserveException {
        return reserveRepo.findAll();
    }

    public List<ReserveMongodb> getReserveByLaboratory(String laboratoryAbbreviation) throws LabReserveException {
        return reserveRepo.findByLaboratoryName(laboratoryAbbreviation);
        /**List<ReserveMongodb> labReserves = new ArrayList<ReserveMongodb>();
        List<ReserveMongodb> reserves = reserveRepo.findAll();
        for (ReserveMongodb reserveMongodb : reserves) {
            String abreviation = reserveMongodb.getSchedule().getLaboratory().getAbbreviation();
            if (abreviation.equals(laboratoryAbbreviation)) {
                labReserves.add(reserveMongodb);
            }
        }
        return labReserves;*/
    }

    public List<ReserveMongodb> getReserveByUser(String userId) throws LabReserveException {
        return reserveRepo.findByUserId(userId);
    }

    public List<ReserveMongodb> getReserveByDay(DayOfWeek day) throws LabReserveException {
        return reserveRepo.findByDay(day);
        /**List<ReserveMongodb> labReserves = new ArrayList<ReserveMongodb>();
        List<ReserveMongodb> reserves = reserveRepo.findAll();
        for (ReserveMongodb reserveMongodb : reserves) {
            DayOfWeek dayReserves = reserveMongodb.getSchedule().getDay();
            if (day.equals(dayReserves)) {
                labReserves.add(reserveMongodb);
            }
        }
        return labReserves; */
    }

    public List<ReserveMongodb> getReserveByMonth(Month month) throws LabReserveException {
        return reserveRepo.findByMonth(month);
        /**List<ReserveMongodb> labReserves = new ArrayList<ReserveMongodb>();
         List<ReserveMongodb> reserves = reserveRepo.findAll();
         for (ReserveMongodb reserveMongodb : reserves) {
         Month monthReserves = reserveMongodb.getSchedule().getMonth();
         if (month.equals(monthReserves)) {
         labReserves.add(reserveMongodb);
         }
         }
         return labReserves; */
    }

    public ReserveMongodb getReserveById(int id) throws LabReserveException {
        return reserveRepo.findById(id);
    }
}