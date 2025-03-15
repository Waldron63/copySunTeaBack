package edu.eci.cvds.labReserves.services;
import edu.eci.cvds.labReserves.collections.ReserveMongodb;
import edu.eci.cvds.labReserves.collections.ScheduleMongodb;
import edu.eci.cvds.labReserves.repository.mongodb.*;
import edu.eci.cvds.labReserves.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @Autowired
    private ScheduleMongoRepository scheduleRepo;

    /**
     * Saves a reserve .
     *
     * @param reserve the reserve made of the user
     * @return the saved Reserve object
     */
    public ReserveMongodb saveReserve(Reserve reserve) throws LabReserveException {
        ReserveMongodb resMongo = new ReserveMongodb(reserve);
        return reserveRepo.save(resMongo);
    }

    public ScheduleMongodb saveSchedule(Schedule schedule) throws LabReserveException {
        ScheduleMongodb scheduleMongodb = new ScheduleMongodb(schedule);
        return scheduleRepo.save(scheduleMongodb);
    }

    public ResponseEntity<Void> deleteReserveByScheduleId(int scheduleId) throws LabReserveException {
        ReserveMongodb resMongo = reserveRepo.findByScheduleId(scheduleId);
        reserveRepo.deleteById(resMongo.getId());
        return ResponseEntity.noContent().build();
    }

    public void deleteById(Schedule schedule) throws LabReserveException {
        scheduleRepo.deleteById(schedule.getId());
    }

    public ScheduleMongodb getScheduleBySchedule(Schedule schedule) throws LabReserveException {
        return scheduleRepo.findByTime(schedule.getStartHour(), schedule.getNumberDay(),
                schedule.getDay(), schedule.getMonth(), schedule.getYear());
    }

    public ResponseEntity<Void> deleteAllReserveByUser(int userId) throws LabReserveException {
        reserveRepo.deleteAllByUserId(userId);
        return ResponseEntity.noContent().build();
    }

    public List<ReserveMongodb> getAllReserves() throws LabReserveException {
        return reserveRepo.findAll();
    }

    /**
    public List<ReserveMongodb> getReserveByLaboratory(String laboratoryAbbreviation) throws LabReserveException {
        //return reserveRepo.findByLaboratoryName(laboratoryAbbreviation);
        List<ReserveMongodb> labReserves = new ArrayList<>();
        List<ReserveMongodb> reserves = reserveRepo.findAll();
        for (ReserveMongodb reserveMongodb : reserves) {
            int scheduleId = reserveMongodb.getScheduleId();
            String abreviation = reserveMongodb.getSchedule().getLaboratory().getAbbreviation();
            if (abreviation.equals(laboratoryAbbreviation)) {
                labReserves.add(reserveMongodb);
            }
        }
        return labReserves;
    }*/

    public List<ReserveMongodb> getReserveByUser(int userId) throws LabReserveException {
        return reserveRepo.findByUserId(userId);
    }

    public List<ReserveMongodb> getReserveByDay(DayOfWeek day) throws LabReserveException {
        //return reserveRepo.findByDay(day);
        List<ReserveMongodb> labReserves = new ArrayList<>();
        List<ReserveMongodb> reserves = reserveRepo.findAll();
        for (ReserveMongodb reserveMongodb : reserves) {
            ScheduleMongodb scheduleMongodb = scheduleRepo.findById(reserveMongodb.getSchedule());
            DayOfWeek dayReserves = scheduleMongodb.getDay();
            if (day.equals(dayReserves)) {
                labReserves.add(reserveMongodb);
            }
        }
        return labReserves;
    }

    public List<ReserveMongodb> getReserveByMonth(Month month) throws LabReserveException {
        //return reserveRepo.findByMonth(month);
        List<ReserveMongodb> labReserves = new ArrayList<>();
         List<ReserveMongodb> reserves = reserveRepo.findAll();
         for (ReserveMongodb reserveMongodb : reserves) {
             ScheduleMongodb scheduleMongodb = scheduleRepo.findById(reserveMongodb.getSchedule());
             Month monthReserves = scheduleMongodb.getMonth();
             if (month.equals(monthReserves)) {
                labReserves.add(reserveMongodb);
             }
         }
         return labReserves;
    }

    public ReserveMongodb getReserveById(int id) throws LabReserveException {
        return reserveRepo.findById(id);
    }

    public List<ReserveMongodb> getReserveByUserId(int userId) {
        return reserveRepo.getAllByUserId(userId);
    }
}