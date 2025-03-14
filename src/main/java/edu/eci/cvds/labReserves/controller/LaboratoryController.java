package edu.eci.cvds.labReserves.controller;

import edu.eci.cvds.labReserves.collections.LaboratoryMongodb;
import edu.eci.cvds.labReserves.model.Schedule;
import edu.eci.cvds.labReserves.services.LaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gestionar las operaciones de laboratorio.
 */
@RestController
@RequestMapping("/api/laboratories")
@CrossOrigin(origins = "*")
public class LaboratoryController {

    private final LaboratoryService laboratoryService;

    @Autowired
    public LaboratoryController(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }


    @GetMapping
    public ResponseEntity<List<LaboratoryMongodb>> getAllLaboratories() {
        List<LaboratoryMongodb> laboratories = laboratoryService.getAllLaboratories();
        return new ResponseEntity<>(laboratories, HttpStatus.OK);
    }


    @GetMapping("/{abbreviation}")
    public ResponseEntity<LaboratoryMongodb> getLaboratoryByAbbreviation(@PathVariable String abbreviation) {
        Optional<LaboratoryMongodb> laboratory = laboratoryService.getLaboratoryByAbbreviation(abbreviation);
        return laboratory.map(lab -> new ResponseEntity<>(lab, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<LaboratoryMongodb> createLaboratory(@RequestBody LaboratoryMongodb laboratory) {
        LaboratoryMongodb createdLaboratory = laboratoryService.createLaboratory(laboratory);
        return new ResponseEntity<>(createdLaboratory, HttpStatus.CREATED);
    }


    @DeleteMapping("/{abbreviation}")
    public ResponseEntity<Void> deleteLaboratory(@PathVariable String abbreviation) {
        // Suponiendo que hay un método de eliminación en el servicio.
        laboratoryService.deleteLaboratory(abbreviation);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
