package edu.eci.cvds.labReserves.repository.mongodb;

import edu.eci.cvds.labReserves.collections.ReserveMongodb;
import edu.eci.cvds.labReserves.collections.ScheduleMongodb;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

@Repository

public interface ScheduleMongoRepository extends MongoRepository<ScheduleMongodb, String> {

    @Query("{ 'startHour' : ?0, 'numberDay' : ?1, 'day' : ?2, 'month' : ?3, 'year' : ?4 }")
    ScheduleMongodb findByTime(LocalTime startHour, int numberDay, DayOfWeek day, Month month, int year);

    void deleteById(int id);

    ScheduleMongodb findById(int id);
}
