package edu.eci.cvds.labReserves.controller;

import edu.eci.cvds.labReserves.collections.ReserveMongodb;
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



/**
 * The ReserveController class handles HTTP requests for managing reserves.
 * It provides endpoints to create, retrieve, update, and delete reserves.
 */
@RestController
@RequestMapping("/reserve")
public class ReserveController {

    @Autowired
    private ReserveService reserveService;

    @GetMapping("/{}")
    public void reserve() {
        return ;
    }

    @PostMapping("/{}")
    public Reserve createReserve(@RequestBody Reserve reserve) throws LabReserveException {
        return reserveService.saveReserve(reserve);
    }

    @DeleteMapping("/{}")
    public void deleteReserveBySchedule(@RequestBody Schedule schedule) throws LabReserveException {
        reserveService.deleteReserveBySchedule(schedule);
    }

    @DeleteMapping("/{}")
    public void deleteReserveByUser(@PathVariable String userId) throws LabReserveException {
        reserveService.deleteAllReserveByUser(userId);
    }

    @GetMapping("/{}")
    public List<ReserveMongodb> getAllReserves() throws LabReserveException {
        return reserveService.getAllReserves();
    }

    @GetMapping("/{}")
    public List<ReserveMongodb> getReserveByLaboratory(@PathVariable String labAbreviation) throws LabReserveException {
        return reserveService.getReserveByLaboratory(labAbreviation);
    }

    @GetMapping("/{}")
    public List<ReserveMongodb> getReserveByUser(@PathVariable String userId) throws LabReserveException {
        return reserveService.getReserveByUser(userId);
    }

    @GetMapping("/{}")
    public List<ReserveMongodb> getReserveByDay(@PathVariable DayOfWeek day) throws LabReserveException {
        return reserveService.getReserveByDay(day);
    }

    @GetMapping("/{}")
    public List<ReserveMongodb> getReserveByMonth(@PathVariable Month month) throws LabReserveException {
        return reserveService.getReserveByMonth(month);
    }

    @GetMapping("/{}")
    public ReserveMongodb getReserveById(@PathVariable int id) throws LabReserveException {
        return reserveService.getReserveById(id);
    }
}
