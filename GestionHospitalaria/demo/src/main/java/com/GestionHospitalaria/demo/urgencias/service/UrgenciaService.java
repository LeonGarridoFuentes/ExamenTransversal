package com.GestionHospitalaria.demo.urgencias.service;

import com.GestionHospitalaria.demo.urgencias.model.Urgencia;
import com.GestionHospitalaria.demo.urgencias.repository.UrgenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UrgenciaService {

    @Autowired
    private UrgenciaRepository urgenciaRepository;

    public List<Urgencia> listar() {
        return urgenciaRepository.findAll();
    }

    public Urgencia guardar(Urgencia urgencia) {
        return urgenciaRepository.save(urgencia);
    }

    public Urgencia actualizar(Integer id, Urgencia urgenciaAct) {
        return urgenciaRepository.findById(id).map(urgencia -> {
            urgencia.setFechaHoraIngreso(urgenciaAct.getFechaHoraIngreso());
            urgencia.setTriage(urgenciaAct.getTriage());
            urgencia.setMotivoConsulta(urgenciaAct.getMotivoConsulta());
            urgencia.setPaciente(urgenciaAct.getPaciente());
            urgencia.setMedico(urgenciaAct.getMedico());
            return urgenciaRepository.save(urgencia);
        }).orElseThrow(() -> new RuntimeException("Registro de urgencia no encontrado"));
    }

    public void eliminar(Integer id) {
        urgenciaRepository.deleteById(id);
    }
}