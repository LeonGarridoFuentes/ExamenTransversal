package com.GestionHospitalaria.demo.pacientes.service;

import com.GestionHospitalaria.demo.pacientes.model.Paciente;
import com.GestionHospitalaria.demo.pacientes.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository repo;

    public List<Paciente> listar() {
        return repo.findAll();
    }

    public Paciente guardar(Paciente p) {
        return repo.save(p);
    }
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}