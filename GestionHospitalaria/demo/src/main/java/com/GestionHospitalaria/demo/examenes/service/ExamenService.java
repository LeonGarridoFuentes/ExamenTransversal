package com.GestionHospitalaria.demo.examenes.service;

import com.GestionHospitalaria.demo.examenes.model.Examen;
import com.GestionHospitalaria.demo.examenes.repository.ExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExamenService {

    @Autowired
    private ExamenRepository examenRepository;

    public List<Examen> listar() {
        return examenRepository.findAll();
    }

    public Examen guardar(Examen examen) {
        return examenRepository.save(examen);
    }

    public Examen actualizar(Integer id, Examen examenAct) {
        return examenRepository.findById(id).map(examen -> {
            examen.setNombreExamen(examenAct.getNombreExamen());
            examen.setFechaSolicitud(examenAct.getFechaSolicitud());
            examen.setResultado(examenAct.getResultado());
            examen.setPaciente(examenAct.getPaciente());
            examen.setMedico(examenAct.getMedico());
            return examenRepository.save(examen);
        }).orElseThrow(() -> new RuntimeException("Examen no encontrado"));
    }

    public void eliminar(Integer id) {
        examenRepository.deleteById(id);
    }
}