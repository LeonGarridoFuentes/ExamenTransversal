package com.GestionHospitalaria.demo.fichasClinicas.controller;

import com.GestionHospitalaria.demo.fichasClinicas.model.FichaClinica;
import com.GestionHospitalaria.demo.fichasClinicas.service.FichaClinicaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/fichas-clinicas")
@Tag(name = "Fichas Clínicas", description = "Endpoints para el historial y antecedentes médicos")
public class FichaClinicaController {

    @Autowired
    private FichaClinicaService fichaClinicaService;

    @GetMapping(value = {"", "/"})
    public List<FichaClinica> listar() {
        return fichaClinicaService.listar();
    }

    @PostMapping(value = {"", "/"})
    public FichaClinica guardar(@RequestBody FichaClinica fichaClinica) {
        return fichaClinicaService.guardar(fichaClinica);
    }
    @PutMapping("/{id}")
    public FichaClinica actualizar(@PathVariable Integer id, @RequestBody FichaClinica fichaClinica) {
        return fichaClinicaService.actualizar(id, fichaClinica);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        fichaClinicaService.eliminar(id);
    }
}