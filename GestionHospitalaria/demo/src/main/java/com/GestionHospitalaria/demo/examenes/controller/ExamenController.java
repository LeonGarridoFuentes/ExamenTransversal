package com.GestionHospitalaria.demo.examenes.controller;

import com.GestionHospitalaria.demo.examenes.model.Examen;
import com.GestionHospitalaria.demo.examenes.service.ExamenService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/examenes")
@Tag(name = "Exámenes Clínicos", description = "Endpoints para la orden y resultados de exámenes laboratoriales")
public class ExamenController {

    @Autowired
    private ExamenService examenService;

    @GetMapping(value = {"", "/"})
    public List<Examen> listar() {
        return examenService.listar();
    }

    @PostMapping(value = {"", "/"})
    public Examen guardar(@RequestBody Examen examen) {
        return examenService.guardar(examen);
    }

    @PutMapping("/{id}")
    public Examen actualizar(@PathVariable Integer id, @RequestBody Examen examen) {
        return examenService.actualizar(id, examen);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        examenService.eliminar(id);
    }
}