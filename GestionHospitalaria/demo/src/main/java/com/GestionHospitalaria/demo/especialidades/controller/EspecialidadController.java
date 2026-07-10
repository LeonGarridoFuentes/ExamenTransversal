package com.GestionHospitalaria.demo.especialidades.controller;

import com.GestionHospitalaria.demo.especialidades.model.Especialidad;
import com.GestionHospitalaria.demo.especialidades.service.EspecialidadService;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/especialidades")
@Tag(name = "Gestión de especialidades", description = "Endpoints para el manejo de especialidades")
public class EspecialidadController {

    @Autowired
    private EspecialidadService service;

    @GetMapping
    public ResponseEntity<List<Especialidad>> obtenerTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @PostMapping
    public ResponseEntity<Especialidad> crear(@Valid @RequestBody Especialidad especialidad) {
        return new ResponseEntity<>(service.guardar(especialidad), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especialidad> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Especialidad> actualizar(@PathVariable Long id, @Valid @RequestBody Especialidad especialidad) {
        return ResponseEntity.ok(service.editar(id, especialidad));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}