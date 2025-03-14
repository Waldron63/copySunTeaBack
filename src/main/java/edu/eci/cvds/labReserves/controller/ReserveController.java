package edu.eci.cvds.labReserves.controller;

import edu.eci.cvds.labReserves.collections.ReserveMongodb;
import edu.eci.cvds.labReserves.model.LabReserveException;
import edu.eci.cvds.labReserves.model.Reserve;
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
    public void deleteReserveBySchedule(@PathVariable int id) throws LabReserveException {
        //return reserveService.deleteReserveBySchedule();
        return;
    }

    @DeleteMapping("/{}")
    public void deleteReserveByUser(@PathVariable int id) throws LabReserveException {
        //reserveService.deleteAllReserveByUser();
        return;
    }

    @GetMapping("/{}")
    public List<ReserveMongodb> getAllReserves(@PathVariable int id) throws LabReserveException {
        return reserveService.getAllReserves();
    }

    @GetMapping("/{}")
    public Reserve getReserveByUser(@PathVariable String user) throws LabReserveException {
        //return reserveService.getReserveByUser(user);
        return null;
    }

    @GetMapping("/{}")
    public Reserve getReserveByDay(@PathVariable DayOfWeek id) throws LabReserveException {
        //return reserveService.getReserveByDay(id);
        return null;
    }

    @GetMapping("/{}")
    public Reserve getReserveByMonth(@PathVariable String month) throws LabReserveException {
        //return reserveService.getReserveByLaboratory(month);
        return null;
    }
}
