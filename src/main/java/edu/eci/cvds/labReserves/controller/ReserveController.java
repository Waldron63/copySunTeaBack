package edu.eci.cvds.labReserves.controller;

import edu.eci.cvds.labReserves.collections.ReserveMongodb;
import edu.eci.cvds.labReserves.collections.ScheduleMongodb;
import edu.eci.cvds.labReserves.dto.ReserveRequest;
import edu.eci.cvds.labReserves.model.LabReserveException;
import edu.eci.cvds.labReserves.model.Reserve;
import edu.eci.cvds.labReserves.model.Schedule;
import edu.eci.cvds.labReserves.model.User;
import edu.eci.cvds.labReserves.services.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.List;
import java.util.Optional;


/**
 * The ReserveController class handles HTTP requests for managing reserves.
 * It provides endpoints to create, retrieve, update, and delete reserves.
 */
@RestController
@RequestMapping("/api/reserve")
public class ReserveController {

    @Autowired
    private ReserveService reserveService;

    @PostMapping("")
    public ReserveMongodb createReserve(@RequestBody ReserveRequest reserveRequest) throws LabReserveException {
        Schedule schedule = new Schedule(reserveRequest.getStartHour(), reserveRequest.getNumberDay(),
                reserveRequest.getDay(), reserveRequest.getMonth(), reserveRequest.getYear());
        Reserve reserve = new Reserve(reserveRequest.getType(),
                reserveRequest.getReason(), reserveRequest.getUserId());
        reserveService.saveSchedule(schedule);
        reserve.setSchedule(schedule.getId());
        return reserveService.saveReserve(reserve);
    }

    @DeleteMapping("/schedules")
    public void deleteReserveBySchedule(@RequestBody Schedule schedule) throws LabReserveException {
        ScheduleMongodb scheduleMongodb = reserveService.getScheduleBySchedule(schedule);
        reserveService.deleteReserveByScheduleId(scheduleMongodb.getId());
        reserveService.deleteById(scheduleMongodb);
    }

    /**
     * Deletes all reserves by user ID.
     */
    @DeleteMapping("/users/{userId}")
    public void deleteReserveByUser(@PathVariable int userId) throws LabReserveException {
        List<ReserveMongodb> reserveMongodbs = reserveService.getReserveByUserId(userId);
        for (ReserveMongodb reserveMongodb : reserveMongodbs) {
            reserveService.deleteReserveByScheduleId(reserveMongodb.getSchedule());
        }
        reserveService.deleteAllReserveByUser(userId);
    }

    /**
     * Retrieves all reserves.
     */
    @GetMapping("/reserves")
    public List<ReserveMongodb> getAllReserves() throws LabReserveException {
        return reserveService.getAllReserves();
    }

    /**
     * Retrieves reserves by laboratory abbreviation.

    @GetMapping("/lab/{labAbbreviation}")
    public List<ReserveMongodb> getReserveByLaboratory(@PathVariable String labAbbreviation) throws LabReserveException {
        return reserveService.getReserveByLaboratory(labAbbreviation);
    }*/

    /**
     * Retrieves reserves by user ID.
     */
    @GetMapping("/users/{userId}")
    public List<ReserveMongodb> getReserveByUser(@PathVariable int   userId) throws LabReserveException {
        return reserveService.getReserveByUser(userId);
    }

    /**
     * Retrieves reserves by day (as a string to avoid enum issues).
     */
    @GetMapping("/day/{day}")
    public List<ReserveMongodb> getReserveByDay(@PathVariable DayOfWeek day) throws LabReserveException {
        return reserveService.getReserveByDay(day);
    }

    /**
     * Retrieves reserves by month (as a string to avoid enum issues).
     */
    @GetMapping("/month/{month}")
    public List<ReserveMongodb> getReserveByMonth(@PathVariable Month month) throws LabReserveException {
        return reserveService.getReserveByMonth(month);
    }

    /**
     * Retrieves a reserve by its ID.
     */
    @GetMapping("/{id}")
    public ReserveMongodb getReserveById(@PathVariable int id) throws LabReserveException {
        return reserveService.getReserveById(id);
    }
}
