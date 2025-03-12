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

    /**
     * GET /api/laboratories : Obtener todos los laboratorios.
     *
     * @return ResponseEntity con estado 200 (OK) y la lista de laboratorios.
     */
    @GetMapping
    public ResponseEntity<List<LaboratoryMongodb>> getAllLaboratories() {
        List<LaboratoryMongodb> laboratories = laboratoryService.getAllLaboratories();
        return new ResponseEntity<>(laboratories, HttpStatus.OK);
    }

    /**
     * GET /api/laboratories/{abbreviation} : Obtener un laboratorio por su abreviatura.
     *
     * @param abbreviation abreviatura del laboratorio a recuperar.
     * @return ResponseEntity con estado 200 (OK) y el laboratorio, o 404 (No encontrado).
     */
    @GetMapping("/{abbreviation}")
    public ResponseEntity<LaboratoryMongodb> getLaboratoryByAbbreviation(@PathVariable String abbreviation) {
        Optional<LaboratoryMongodb> laboratory = laboratoryService.getLaboratoryByAbbreviation(abbreviation);
        return laboratory.map(lab -> new ResponseEntity<>(lab, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * POST /api/laboratories : Crear un nuevo laboratorio.
     *
     * @param laboratory el laboratorio a crear.
     * @return ResponseEntity con estado 201 (Creado) y el nuevo laboratorio.
     */
    @PostMapping
    public ResponseEntity<LaboratoryMongodb> createLaboratory(@RequestBody LaboratoryMongodb laboratory) {
        LaboratoryMongodb createdLaboratory = laboratoryService.createLaboratory(laboratory);
        return new ResponseEntity<>(createdLaboratory, HttpStatus.CREATED);
    }


    /**
     * DELETE /api/laboratories/{abbreviation} : Eliminar un laboratorio.
     *
     * @param abbreviation abreviatura del laboratorio a eliminar.
     * @return ResponseEntity con estado 204 (Sin contenido).
     */
    @DeleteMapping("/{abbreviation}")
    public ResponseEntity<Void> deleteLaboratory(@PathVariable String abbreviation) {
        // Suponiendo que hay un método de eliminación en el servicio.
        laboratoryService.deleteLaboratory(abbreviation);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
