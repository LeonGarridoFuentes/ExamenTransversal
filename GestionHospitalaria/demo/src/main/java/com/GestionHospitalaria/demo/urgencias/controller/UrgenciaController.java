package com.GestionHospitalaria.demo.urgencias.controller;

import com.GestionHospitalaria.demo.urgencias.model.Urgencia;
import com.GestionHospitalaria.demo.urgencias.service.UrgenciaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/urgencias")
@Tag(name = "Gestión de Urgencias", description = "Endpoints para el ingreso y control de pacientes en emergencias")
public class UrgenciaController {

    @Autowired
    private UrgenciaService urgenciaService;

    @GetMapping(value = {"", "/"})
    public List<Urgencia> listar() {
        return urgenciaService.listar();
    }

    @PostMapping(value = {"", "/"})
    public Urgencia guardar(@RequestBody Urgencia urgencia) {
        return urgenciaService.guardar(urgencia);
    }

    @PutMapping("/{id}")
    public Urgencia actualizar(@PathVariable Integer id, @RequestBody Urgencia urgencia) {
        return urgenciaService.actualizar(id, urgencia);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        urgenciaService.eliminar(id);
    }
}