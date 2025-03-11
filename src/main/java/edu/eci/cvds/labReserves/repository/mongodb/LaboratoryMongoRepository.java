package edu.eci.cvds.labReserves.repository.mongodb;
import edu.eci.cvds.labReserves.model.Laboratory;
import edu.eci.cvds.labReserves.model.Reserve;
import edu.eci.cvds.labReserves.model.Resource;
import edu.eci.cvds.labReserves.model.Schedule;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;
import edu.eci.cvds.labReserves.collections.LaboratoryMongodb;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

@Repository
public interface LaboratoryMongoRepository extends MongoRepository<LaboratoryMongodb, String> {
    // consultar detalles del aula
    List<Resource> findAll(Resource resource);
    // consultar horarios disponibles por dia
    List<Schedule> findAllByDay(String day);
    // consultar laboratorio por nombre
    Laboratory findByName(String name);
    // consultar recursos por laboratorio
    List<Resource> findAllByName(String name);


}
