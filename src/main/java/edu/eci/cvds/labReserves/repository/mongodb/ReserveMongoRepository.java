package edu.eci.cvds.labReserves.repository.mongodb;
import edu.eci.cvds.labReserves.collections.ReserveMongodb;
import edu.eci.cvds.labReserves.model.Reserve;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

@Repository
public interface ReserveMongoRepository extends MongoRepository<ReserveMongodb, String>{
    // cancalar reserva
    void deleteByScheduleStartHour(String startHour);
    // guardar o actualizar reservas
    void saveReserve(Reserve reserve);
    // consultar reservas activas
    @Query("{ 'state' : 'reserved'}")
    List<Reserve> searchByState(String state);
    // buscar reservas por usuario
    List<Reserve> searchByUser_id(String user_id);

}
