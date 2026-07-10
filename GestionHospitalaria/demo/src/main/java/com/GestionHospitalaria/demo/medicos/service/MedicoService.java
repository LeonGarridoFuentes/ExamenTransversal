package com.GestionHospitalaria.demo.medicos.service;

import com.GestionHospitalaria.demo.medicos.model.Medico;
import com.GestionHospitalaria.demo.medicos.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public List<Medico> listarTodos() {
        return medicoRepository.findAll();
    }

    public Optional<Medico> buscarPorId(Long id) {
        return medicoRepository.findById(id);
    }

    public Medico guardar(Medico medico) {
        return medicoRepository.save(medico);
    }

    public void eliminar(Long id) {
        medicoRepository.deleteById(id);
    }
}