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

}
