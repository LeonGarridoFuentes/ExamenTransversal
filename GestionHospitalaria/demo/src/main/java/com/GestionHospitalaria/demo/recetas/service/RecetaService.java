package com.GestionHospitalaria.demo.recetas.service;

import com.GestionHospitalaria.demo.recetas.model.Receta;
import com.GestionHospitalaria.demo.recetas.repository.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecetaService {

    @Autowired
    private RecetaRepository recetaRepository;

    public List<Receta> listar() {
        return recetaRepository.findAll();
    }

    public Receta guardar(Receta receta) {
        return recetaRepository.save(receta);
    }

    public Receta actualizar(Integer id, Receta recetaActualizada) {
        return recetaRepository.findById(id).map(receta -> {
            receta.setFechaEmision(recetaActualizada.getFechaEmision());
            receta.setMedicamento(recetaActualizada.getMedicamento());
            receta.setPosologia(recetaActualizada.getPosologia());
            receta.setPaciente(recetaActualizada.getPaciente());
            receta.setMedico(recetaActualizada.getMedico());
            return recetaRepository.save(receta);
        }).orElseThrow(() -> new RuntimeException("Receta no encontrada"));
    }

    public void eliminar(Integer id) {
        recetaRepository.deleteById(id);
    }
}