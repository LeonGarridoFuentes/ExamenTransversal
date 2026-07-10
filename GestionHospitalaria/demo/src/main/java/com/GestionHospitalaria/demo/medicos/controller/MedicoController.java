package com.GestionHospitalaria.demo.medicos.controller;

import com.GestionHospitalaria.demo.medicos.model.Medico;
import com.GestionHospitalaria.demo.medicos.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
@Tag(name = "Gestión de Médicos", description = "Endpoints para el manejo de personal médico")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping
    public List<Medico> obtenerTodos() {
        return medicoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> obtenerPorId(@PathVariable Long id) {
        return medicoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crearMedico(@RequestBody Medico medico) {
        if (medico.getEspecialidad() == null || medico.getEspecialidad().getId() == null) {
            return ResponseEntity.badRequest().body("Error: Debe incluir el JSON de la especialidad con su ID.");
        }

        Long espId = medico.getEspecialidad().getId();

        try {
            String urlEspecialidad = "http://localhost:8081/api/especialidades/" + espId;
            restTemplate.getForEntity(urlEspecialidad, Object.class);

            Medico nuevoMedico = medicoService.guardar(medico);
            return ResponseEntity.ok(nuevoMedico);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: La especialidad con ID " + espId + " no existe en el sistema.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarMedico(@PathVariable Long id, @RequestBody Medico medicoDetalles) {
        return medicoService.buscarPorId(id).map(medico -> {
            if (medicoDetalles.getEspecialidad() != null && medicoDetalles.getEspecialidad().getId() != null) {
                Long espId = medicoDetalles.getEspecialidad().getId();
                try {
                    String urlEspecialidad = "http://localhost:8081/api/especialidades/" + espId;
                    restTemplate.getForEntity(urlEspecialidad, Object.class);
                    medico.setEspecialidad(medicoDetalles.getEspecialidad());
                } catch (Exception e) {
                    return ResponseEntity.badRequest().body("Error: La nueva especialidad con ID " + espId + " no existe.");
                }
            }
            medico.setNombre(medicoDetalles.getNombre());
            medico.setApellido(medicoDetalles.getApellido());
            medico.setGmail(medicoDetalles.getGmail());
            return ResponseEntity.ok(medicoService.guardar(medico));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMedico(@PathVariable Long id) {
        if (medicoService.buscarPorId(id).isPresent()) {
            medicoService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}