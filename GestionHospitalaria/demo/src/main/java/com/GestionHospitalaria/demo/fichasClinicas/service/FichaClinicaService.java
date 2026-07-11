package com.GestionHospitalaria.demo.fichasClinicas.service;

import com.GestionHospitalaria.demo.fichasClinicas.model.FichaClinica;
import com.GestionHospitalaria.demo.fichasClinicas.repository.FichaClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FichaClinicaService {

    @Autowired
    private FichaClinicaRepository fichaClinicaRepository;

    public List<FichaClinica> listar() {
        return fichaClinicaRepository.findAll();
    }

    public FichaClinica guardar(FichaClinica fichaClinica) {
        return fichaClinicaRepository.save(fichaClinica);
    }
    public FichaClinica actualizar(Integer id, FichaClinica fichaActualizada) {
        return fichaClinicaRepository.findById(id).map(ficha -> {
            ficha.setFechaRegistro(fichaActualizada.getFechaRegistro());
            ficha.setDiagnostico(fichaActualizada.getDiagnostico());
            ficha.setTratamiento(fichaActualizada.getTratamiento());
            ficha.setPaciente(fichaActualizada.getPaciente());
            ficha.setMedico(fichaActualizada.getMedico());
            return fichaClinicaRepository.save(ficha);
        }).orElseThrow(() -> new RuntimeException("Ficha clínica no encontrada"));
    }

    public void eliminar(Integer id) {
        fichaClinicaRepository.deleteById(id);
    }
}