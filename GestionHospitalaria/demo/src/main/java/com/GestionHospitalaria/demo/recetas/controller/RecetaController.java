package com.GestionHospitalaria.demo.recetas.controller;

import com.GestionHospitalaria.demo.recetas.model.Receta;
import com.GestionHospitalaria.demo.recetas.service.RecetaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/recetas")
@Tag(name = "Recetas Médicas", description = "Endpoints para la emisión y consulta de recetas farmacológicas")
public class RecetaController {

    @Autowired
    private RecetaService recetaService;

    @GetMapping(value = {"", "/"})
    public List<Receta> listar() {
        return recetaService.listar();
    }

    @PostMapping(value = {"", "/"})
    public Receta guardar(@RequestBody Receta receta) {
        return recetaService.guardar(receta);
    }
    @PutMapping("/{id}")
    public Receta actualizar(@PathVariable Integer id, @RequestBody Receta receta) {
        return recetaService.actualizar(id, receta);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        recetaService.eliminar(id);
    }
}