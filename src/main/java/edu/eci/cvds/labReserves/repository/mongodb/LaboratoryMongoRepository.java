package edu.eci.cvds.labReserves.repository.mongodb;
import org.springframework.stereotype.Repository;
import edu.eci.cvds.labReserves.collections.LaboratoryMongodb;
import org.springframework.data.mongodb.repository.MongoRepository;
@Repository
public interface LaboratoryMongoRepository extends MongoRepository<LaboratoryMongodb, String> {
}
