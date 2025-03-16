package edu.eci.cvds.labReserves.services;
import edu.eci.cvds.labReserves.collections.ReserveMongodb;
import edu.eci.cvds.labReserves.collections.ScheduleMongodb;
import edu.eci.cvds.labReserves.dto.ReserveRequest;
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
    private ReserveMongoRepository reserveRepo; //interface of Reserve
    @Autowired
    private ScheduleMongoRepository scheduleRepo; //interface of Schedule

    /**
     * Saves a reserve .
     *
     * @param reserveRequest the reserve made of the user
     * @return the saved Reserve object
     */
    public ReserveMongodb saveReserve(ReserveRequest reserveRequest) throws LabReserveException {
        Schedule schedule = new Schedule(reserveRequest.getStartHour(), reserveRequest.getNumberDay(),
                reserveRequest.getDay(), reserveRequest.getMonth(),
                reserveRequest.getYear(), reserveRequest.getLaboratoryName());
        Reserve reserve = new Reserve(reserveRequest.getType(),
                reserveRequest.getReason(), reserveRequest.getUserId());
        reserve.setSchedule(schedule.getId());
        ScheduleMongodb scheduleMongodb = new ScheduleMongodb(schedule);
        ReserveMongodb resMongo = new ReserveMongodb(reserve);
        scheduleRepo.save(scheduleMongodb);
        reserveRepo.save(resMongo);
        return resMongo;
    }

    /**
     * Deletes a reservation by its associated schedule ID.
     *
     * @param scheduleId The schedule ID linked to the reservation.
     * @return A {@code ResponseEntity} indicating success or failure.
     * @throws LabReserveException If the reservation cannot be found.
     */
    public ResponseEntity<Void> deleteReserveByScheduleId(int scheduleId) throws LabReserveException {
        ReserveMongodb resMongo = reserveRepo.findByScheduleId(scheduleId);
        reserveRepo.deleteById(resMongo.getId());
        return ResponseEntity.noContent().build();
    }

    /**
     * Deletes a schedule by its ID.
     *
     * @param scheduleId The ID of the schedule to delete.
     */
    public void deleteById(int scheduleId){
        scheduleRepo.deleteById(scheduleId);
    }

    /**
     * Deletes a reservation by its ID.
     *
     * @param id The reservation ID to delete.
     * @return A {@code ResponseEntity} indicating success or failure.
     * @throws LabReserveException If the reservation cannot be found.
     */
    public ResponseEntity<Void> deleteReserveById(int id) throws LabReserveException {
        reserveRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Retrieves all reservations.
     *
     * @return A list of {@code ReserveRequest} objects representing all reservations.
     */
    public List<ReserveRequest> getAllReserves() throws LabReserveException {
        //return reserveRepo.findAll();
        List<ReserveMongodb> reserve = reserveRepo.findAll();
        List<ReserveRequest> reserveRequests = new ArrayList<>();
        for (ReserveMongodb reserveMongodb : reserve) {
            ReserveRequest request = new ReserveRequest(reserveMongodb,
                    scheduleRepo.findById(reserveMongodb.getSchedule()));
            reserveRequests.add(request);
        }
        return reserveRequests;
    }

    /**
     * Retrieves reservations by laboratory abbreviation.
     */
    public List<ReserveRequest> getReserveByLaboratory(String laboratoryAbbreviation) throws LabReserveException {
        //return reserveRepo.findByLaboratoryName(laboratoryAbbreviation);
        List<ReserveRequest> labReserves = new ArrayList<>();
        List<ReserveMongodb> reserves = reserveRepo.findAll();
        for (ReserveMongodb reserveMongodb : reserves) {
            int scheduleId = reserveMongodb.getSchedule();
            ScheduleMongodb scheduleMongodb = scheduleRepo.findById(scheduleId);
            String abreviation = scheduleMongodb.getLaboratory();
            if (abreviation.equals(laboratoryAbbreviation)) {
                ReserveRequest request = new ReserveRequest(reserveMongodb, scheduleMongodb);
                labReserves.add(request);
            }
        }
        return labReserves;
    }

    /**
     * Retrieves reservations by user ID.
     */
    public List<ReserveRequest> getReserveByUser(int userId) throws LabReserveException {
        //return reserveRepo.findByUserId(userId);
        List<ReserveMongodb> reserves = reserveRepo.findByUserId(userId);
        List<ReserveRequest> reserveRequests = new ArrayList<>();
        for (ReserveMongodb reserveMongodb : reserves) {
            int scheduleId = reserveMongodb.getSchedule();
            ScheduleMongodb scheduleMongodb = scheduleRepo.findById(scheduleId);
            ReserveRequest request = new ReserveRequest(reserveMongodb, scheduleMongodb);
            reserveRequests.add(request);
        }
        return reserveRequests;
    }

    /**
     * Retrieves reservations by day of the week.
     */
    public List<ReserveRequest> getReserveByDay(DayOfWeek day) throws LabReserveException {
        //return reserveRepo.findByDay(day);
        List<ReserveRequest> labReserves = new ArrayList<>();
        List<ReserveMongodb> reserves = reserveRepo.findAll();
        for (ReserveMongodb reserveMongodb : reserves) {
            ScheduleMongodb scheduleMongodb = scheduleRepo.findById(reserveMongodb.getSchedule());
            DayOfWeek dayReserves = scheduleMongodb.getDay();
            if (day.equals(dayReserves)) {
                ReserveRequest request = new ReserveRequest(reserveMongodb, scheduleMongodb);
                labReserves.add(request);
            }
        }
        return labReserves;
    }

    /**
     * Retrieves reservations by month.
     */
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

    /**
     * Retrieves a  list of reservations by its user ID.
     */
    public List<ReserveMongodb> getReserveByUserId(int userId) {
        return reserveRepo.getAllByUserId(userId);
    }

    /**
     * Retrieves a reservation by its ID.
     */
    public ReserveMongodb getReserveById(int id) throws LabReserveException {
        return reserveRepo.findById(id);
    }

    /**
     * Retrieves a schedule by its ID.
     */
    public ScheduleMongodb getScheduleById(int id) throws LabReserveException {
        return scheduleRepo.findById(id);
    }

    /**
     * Retrieves a schedule based on its details.
     */
    public ScheduleMongodb getScheduleBySchedule(Schedule schedule) throws LabReserveException {
        return scheduleRepo.findByTime(schedule.getStartHour(), schedule.getNumberDay(),
                schedule.getDay(), schedule.getMonth(), schedule.getYear());
    }
}