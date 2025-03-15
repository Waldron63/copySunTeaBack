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

    @Query("{ 'userId' : ?0 }")
    void deleteAllByUserId(int userId);
    /**
    // cancelar reserva
    void deleteByScheduleStartHour(String startHour);
    */

    //@Query("{ '' : ?0 }")
    //List<ReserveMongodb> findByLaboratoryName(String laboratoryAbbreviation);

    @Query("{ 'userId' : ?0 }")
    List<ReserveMongodb> findByUserId(int userId);

    ReserveMongodb findById(int id);

    void deleteById(int id);

    @Query("{ 'scheduleId' : ?0 }")
    ReserveMongodb findByScheduleId(int scheduleId);

    @Query("{ 'userId' : ?0 }")
    List<ReserveMongodb> getAllByUserId(int userId);
    /**
     *
     // consultar reservas activas
     @Query("{ 'state' : 'reserved'}")
     List<Reserve> searchByState(String state);

     // buscar reservas por usuario
    List<Reserve> searchByUser_id(String user_id);
    */
}
