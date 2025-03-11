/*package edu.eci.cvds.labReserves.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.cvds.labReserves.model.Laboratory;
import edu.eci.cvds.labReserves.model.Schedule;
import edu.eci.cvds.labReserves.repository.mongodb.LaboratoryMongoRepository;
import edu.eci.cvds.labReserves.services.LaboratoryService;

@RestController
//@RequestMapping("/laboratory")
public class LaboratoryController {
    private LaboratoryMongoRepository laboratoryRepo;
    
    @Autowired
    private LaboratoryService laboratoryService;

    // Obtener todos los laboratorios GET (otener), ResponseEntity<List<Laboratory>> paquete que contiene la lista de labs
    @GetMapping
    public ResponseEntity<List<Laboratory>> getAllLaboratories() {
        return new ResponseEntity<>(laboratoryService.getAllLaboratories(), HttpStatus.OK);
    }

    // Obtener un laboratorio por nombre corto, @PathVariable String abbreviation es el que coge el valor de la dirección
    @GetMapping("/{abbreviation}")
    public ResponseEntity<Laboratory> getLaboratoryByAbbreviation(@PathVariable String abbreviation) {
        Laboratory laboratory = laboratoryService.getLaboratoryByAbbreviation(abbreviation);
        if (laboratory != null) {
            return new ResponseEntity<>(laboratory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear un nuevo laboratorio POST (crear cosas), @RequestBody coge lo que manda el usuario y lo convierte a objeto
    @PostMapping
    public ResponseEntity<Laboratory> createLaboratory(@RequestBody Laboratory laboratory) {
        return new ResponseEntity<>(laboratoryService.createLaboratory(laboratory), HttpStatus.CREATED);
    }

    // Verificar disponibilidad de un laboratorio
    @PostMapping("/check-availability/{abbreviation}")
    public ResponseEntity<Boolean> checkAvailability(@PathVariable String abbreviation, @RequestBody Schedule schedule) {
        boolean isAvailable = laboratoryService.isLaboratoryAvailable(abbreviation, schedule);
        return new ResponseEntity<>(isAvailable, HttpStatus.OK);
    }

    // Actualizar un laboratorio PUT (actualizar)
    @PutMapping("/{abbreviation}")
    public ResponseEntity<Laboratory> updateLaboratory(@PathVariable String abbreviation, @RequestBody Laboratory laboratory) {
        Laboratory updatedLaboratory = laboratoryService.updateLaboratory(abbreviation, laboratory);
        if (updatedLaboratory != null) {
            return new ResponseEntity<>(updatedLaboratory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un laboratorio DELETE (eliminar)
    @DeleteMapping("/{abbreviation}")
    public ResponseEntity<Void> deleteLaboratory(@PathVariable String abbreviation) {
        boolean deleted = laboratoryService.deleteLaboratory(abbreviation);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}*/
