package edu.eci.cvds.labReserves.repository.mongodb;

import edu.eci.cvds.labReserves.model.LaboratoryMongodb;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LaboratoryMongoRepository extends MongoRepository<LaboratoryMongodb, String> {
}
