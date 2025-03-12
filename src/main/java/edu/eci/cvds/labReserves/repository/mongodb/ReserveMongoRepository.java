package edu.eci.cvds.labReserves.repository.mongodb;

import edu.eci.cvds.labReserves.collections.ReserveMongodb;
import edu.eci.cvds.labReserves.model.Reserve;
import edu.eci.cvds.labReserves.model.Schedule;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.List;

/**
 * The ReserveMongoRepository interface provides the data access layer for Reserves entities.
 * It extends the MongoRepository interface, which provides basic CRUD operations.
 */
@Repository
public interface ReserveMongoRepository extends MongoRepository<ReserveMongodb, String>{
    void deleteBySchedule(Schedule schedule);

    void deleteAllByUserId(String userId);
    /**
    // cancalar reserva
    void deleteByScheduleStartHour(String startHour);
    */
    List<ReserveMongodb> findByLaboratoryName(String laboratoryAbbreviation);

    List<ReserveMongodb> findByUserId(String userId);

    List<ReserveMongodb> findByDay(DayOfWeek day);

    List<ReserveMongodb> findByMonth(Month month);

    ReserveMongodb findById(int id);
    /**
     *
     // consultar reservas activas
     @Query("{ 'state' : 'reserved'}")
     List<Reserve> searchByState(String state);

     // buscar reservas por usuario
    List<Reserve> searchByUser_id(String user_id);
    */
}
