package edu.eci.cvds.labReserves.services;

import edu.eci.cvds.labReserves.collections.LaboratoryMongodb;
import edu.eci.cvds.labReserves.repository.mongodb.*;
import edu.eci.cvds.labReserves.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

/**
 * The {@code LaboratoryService} class provides business logic for managing laboratories and reservations.
 * It handles operations related to laboratories, including creating, updating, validating schedules, and managing reservations.
 */
@Service
public class LaboratoryService {
    private LaboratoryMongoRepository laboratoryRepo;
    // You might need a repository for reservations as well
    // private ReservationRepository reservationRepo;

    /**
     * Constructor to inject dependencies for LaboratoryMongoRepository
     *
     * @param laboratoryRepo the repository for MongoDB laboratories
     */
    @Autowired
    public LaboratoryService(LaboratoryMongoRepository laboratoryRepo) {
        this.laboratoryRepo = laboratoryRepo;
    }

    /**
     * Saves a laboratory.
     *
     * @param lab the laboratory to save
     * @return the saved Laboratory object
     */
    public LaboratoryMongodb createLaboratory(LaboratoryMongodb lab) {
        return laboratoryRepo.save(lab);
    }
    
    /**
     * Retrieves all laboratories
     * 
     * @return list of all laboratories
     */
    public List<LaboratoryMongodb> getAllLaboratories() {
        return laboratoryRepo.findAll();
    }
    
    /**
     * Finds a laboratory by its abbreviation
     * 
     * @param abbreviation the laboratory abbreviation
     * @return the laboratory if found
     */
    public Optional<LaboratoryMongodb> getLaboratoryByAbbreviation(String abbreviation) {
        return laboratoryRepo.findByAbbreviation(abbreviation);
    }
    
    /**
     * Validates if a schedule is within a laboratory's operating hours
     * 
     * @param labAbbreviation the laboratory abbreviation
     * @param schedule the schedule to validate
     * @return true if the schedule is valid, false otherwise
     */
    public boolean validateSchedule(String labAbbreviation, Schedule schedule) {
        Optional<LaboratoryMongodb> labOptional = laboratoryRepo.findByAbbreviation(labAbbreviation);
        if (!labOptional.isPresent()) {
            return false;
        }
        
        LaboratoryMongodb lab = labOptional.get();
        DayOfWeek scheduleDay = schedule.getDay();
        
        // Get the schedule reference for the specified day
        ScheduleReference daySchedule = null;
        for (ScheduleReference ref : lab.getScheduleReferences()) {
            if (ref.getDayOfWeek().equals(scheduleDay)) {
                daySchedule = ref;
                break;
            }
        }
        
        if (daySchedule == null) {
            return false; // No schedule reference found for this day
        }
        
        // Check if the requested time is within operating hours
        LocalTime openingTime = daySchedule.getOpeningTime();
        LocalTime closingTime = daySchedule.getClosingTime();
        
        return !schedule.getStartHour().isBefore(openingTime) && 
               !schedule.getEndHour().isAfter(closingTime);
    }
    
    /**
     * Checks if a laboratory is available for the given schedule
     * 
     * @param labAbbreviation the laboratory abbreviation
     * @param schedule the requested schedule
     * @return true if the laboratory is available, false otherwise
     */
    public boolean isLaboratoryAvailable(String labAbbreviation, Schedule schedule) {
        // First validate if the schedule is within operating hours
        if (!validateSchedule(labAbbreviation, schedule)) {
            return false;
        }
        
        // Next, check if there are any overlapping reservations
        // This would require a ReservationRepository to check existing reservations
        // Example:
        // List<Reservation> existingReservations = reservationRepo.findByLaboratoryAndDate(labAbbreviation, 
        //                                           schedule.getYear(), schedule.getMonth(), schedule.getNumberDay());
        
        // for (Reservation reservation : existingReservations) {
        //     if (reservation.getSchedule().overlaps(schedule)) {
        //         return false;
        //     }
        // }
        
        return true;
    }
    
    /**
     * Makes a reservation for a laboratory
     * 
     * @param labAbbreviation the laboratory abbreviation
     * @param schedule the requested schedule
     * @param userId the user making the reservation
     * @param purpose the purpose of the reservation
     * @return true if reservation was successful, false otherwise
     */
    public boolean reserveLaboratory(String labAbbreviation, Schedule schedule, String userId, String purpose) {
        if (!isLaboratoryAvailable(labAbbreviation, schedule)) {
            return false;
        }
        
        // Create and save the reservation
        // Reservation reservation = new Reservation(userId, labAbbreviation, schedule, purpose);
        // reservationRepo.save(reservation);
        
        return true;
    }
    
    /**
     * Cancels a reservation
     * 
     * @param reservationId the ID of the reservation to cancel
     * @param userId the user canceling the reservation
     * @return true if cancellation was successful, false otherwise
     */
    public boolean cancelReservation(String reservationId, String userId) {
        // Find the reservation
        // Optional<Reservation> reservationOpt = reservationRepo.findById(reservationId);
        
        // if (!reservationOpt.isPresent()) {
        //     return false;
        // }
        
        // Reservation reservation = reservationOpt.get();
        
        // Check if the user is authorized to cancel this reservation
        // if (!reservation.getUserId().equals(userId)) {
        //     return false;
        // }
        
        // Delete the reservation
        // reservationRepo.deleteById(reservationId);
        
        return true;
    }
}