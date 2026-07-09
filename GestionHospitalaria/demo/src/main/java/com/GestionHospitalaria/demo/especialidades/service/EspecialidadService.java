package com.GestionHospitalaria.demo.especialidades.service;

import com.GestionHospitalaria.demo.especialidades.model.Especialidad;
import com.GestionHospitalaria.demo.especialidades.repository.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadService {

    @Autowired
    private EspecialidadRepository repository;

    public List<Especialidad> listarTodas() {
        return repository.findAll();
    }

    public Especialidad guardar(Especialidad especialidad) {
        return repository.save(especialidad);
    }

    public Especialidad buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("no se encontro la id: " + id));
    }

    public Especialidad editar(Long id, Especialidad especialidadActualizada) {
        Especialidad especialidadExistente = buscarPorId(id);
        especialidadExistente.setDescripcion(especialidadActualizada.getDescripcion());

        return repository.save(especialidadExistente);
    }
    public void eliminar(Long id) {
        Especialidad especialidad = buscarPorId(id);
        repository.delete(especialidad);
    }
}