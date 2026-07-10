package com.GestionHospitalaria.demo.pacientes.controller;

import com.GestionHospitalaria.demo.pacientes.model.Paciente;
import com.GestionHospitalaria.demo.pacientes.service.PacienteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/pacientes/")
@Tag(name = "Pacientes", description = "Gestión de pacientes")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @GetMapping(value = {"", "/"}) // Acepta tanto /pacientes como /pacientes/
    public List<Paciente> listar() {
        return service.listar();
    }

    @PostMapping
    public Paciente registrar(@RequestBody Paciente p) {
        return service.guardar(p);
    }
    @PutMapping("/{id}")
    public Paciente actualizar(@PathVariable Integer id, @RequestBody Paciente p) {
        p.setIdPaciente(id);
        return service.guardar(p);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}