package com.GestionHospitalaria.demo.citasMedicas.controller;

import com.GestionHospitalaria.demo.citasMedicas.model.CitaMedica;
import com.GestionHospitalaria.demo.citasMedicas.service.CitaMedicaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/citas-medicas")
@Tag(name = "Citas Médicas", description = "Endpoints para el agendamiento y reserva de horas de atención")
public class CitaMedicaController {

    @Autowired
    private CitaMedicaService citaMedicaService;

    @GetMapping(value = {"", "/"})
    public List<CitaMedica> listar() {
        return citaMedicaService.listar();
    }

    @PostMapping(value = {"", "/"})
    public CitaMedica guardar(@RequestBody CitaMedica citaMedica) {
        return citaMedicaService.guardar(citaMedica);
    }
    @PutMapping("/{id}")
    public CitaMedica actualizar(@PathVariable Integer id, @RequestBody CitaMedica citaMedica) {
        return citaMedicaService.actualizar(id, citaMedica);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        citaMedicaService.eliminar(id);
    }
}