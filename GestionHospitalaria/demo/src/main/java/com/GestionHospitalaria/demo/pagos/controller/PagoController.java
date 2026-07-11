package com.GestionHospitalaria.demo.pagos.controller;

import com.GestionHospitalaria.demo.pagos.model.Pago;
import com.GestionHospitalaria.demo.pagos.service.PagoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pagos")
@Tag(name = "Módulo de Pagos", description = "Endpoints para la gestión de cobros y boletas de atención")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @GetMapping(value = {"", "/"})
    public List<Pago> listar() {
        return pagoService.listar();
    }

    @PostMapping(value = {"", "/"})
    public Pago guardar(@RequestBody Pago pago) {
        return pagoService.guardar(pago);
    }

    @PutMapping("/{id}")
    public Pago actualizar(@PathVariable Integer id, @RequestBody Pago pago) {
        return pagoService.actualizar(id, pago);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        pagoService.eliminar(id);
    }
}