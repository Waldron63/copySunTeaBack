package edu.eci.cvds.labReserves.repository.mongodb;
import edu.eci.cvds.labReserves.collections.ScheduleMongodb;
import edu.eci.cvds.labReserves.model.Laboratory;
import edu.eci.cvds.labReserves.model.Reserve;
import edu.eci.cvds.labReserves.model.Resource;
import edu.eci.cvds.labReserves.model.Schedule;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import edu.eci.cvds.labReserves.collections.LaboratoryMongodb;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

/**
 * The LaboratoryMongoRepository interface provides the data access layer for Laboratories entities.
 * It extends the MongoRepository interface, which provides basic CRUD operations.
 */
@Repository
public interface LaboratoryMongoRepository extends MongoRepository<LaboratoryMongodb, String> {



    // consultar detalles del aula
    List<LaboratoryMongodb> findAll();

    // consultar horarios disponibles por dia
    //List<ScheduleMongodb> findAllByDay(String day);

    // consultar recursos por laboratorio
    @Query("{ 'resource' : ?0 }")
    List<Resource> findAllByRecourses(Resource resource);

    // Busca un laboratorio por su abreviatura
    @Query("{ 'abbreviation' : ?0 }")
    LaboratoryMongodb findByAbbreviation(String abbreviation);

    // Busca un laboratorio por su nombre
    @Query("{ 'name' : ?0 }")
    LaboratoryMongodb findByName(String name);

    // Busca laboratorios por su ubicación
    @Query("{ 'location' : ?0 }")
    List<LaboratoryMongodb> findByLocation(String location);

    // Busca laboratorios por su capacidad total
    @Query("{ 'totalCapacity' : ?0 }")
    List<LaboratoryMongodb> findByTotalCapacity(int totalCapacity);

    // Busca laboratorios con capacidad mayor o igual a la especificada
    @Query("{ 'totalCapacity' : { $gte : ?0 } }")
    List<LaboratoryMongodb> findByTotalCapacityGreaterThanEqual(int capacity);

    // Verifica si existe un laboratorio con la abreviatura dada
    @Query(value = "{ 'abbreviation' : ?0 }", exists = true)
    boolean existsByAbbreviation(String abbreviation);

    // Elimina un laboratorio por su abreviatura
    @Query("{ 'abbreviation' : ?0 }")
    void deleteByAbbreviation(String abbreviation);

}