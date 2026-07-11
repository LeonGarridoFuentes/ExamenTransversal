package com.GestionHospitalaria.demo.hospitalizacion.controller;

import com.GestionHospitalaria.demo.hospitalizacion.model.Hospitalizacion;
import com.GestionHospitalaria.demo.hospitalizacion.service.HospitalizacionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/hospitalizaciones")
@Tag(name = "Hospitalizaciones", description = "Endpoints para el control de camas e ingresos a piso")
public class HospitalizacionController {

    @Autowired
    private HospitalizacionService hospitalizacionService;

    @GetMapping(value = {"", "/"})
    public List<Hospitalizacion> listar() {
        return hospitalizacionService.listar();
    }

    @PostMapping(value = {"", "/"})
    public Hospitalizacion guardar(@RequestBody Hospitalizacion hospitalizacion) {
        return hospitalizacionService.guardar(hospitalizacion);
    }

    @PutMapping("/{id}")
    public Hospitalizacion actualizar(@PathVariable Integer id, @RequestBody Hospitalizacion hospitalizacion) {
        return hospitalizacionService.actualizar(id, hospitalizacion);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        hospitalizacionService.eliminar(id);
    }
}