package com.GestionHospitalaria.demo.citasMedicas.service;

import com.GestionHospitalaria.demo.citasMedicas.model.CitaMedica;
import com.GestionHospitalaria.demo.citasMedicas.repository.CitaMedicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CitaMedicaService {

    @Autowired
    private CitaMedicaRepository citaMedicaRepository;

    public List<CitaMedica> listar() {
        return citaMedicaRepository.findAll();
    }

    public CitaMedica guardar(CitaMedica citaMedica) {
        return citaMedicaRepository.save(citaMedica);
    }
    public CitaMedica actualizar(Integer id, CitaMedica citaActualizada) {
        return citaMedicaRepository.findById(id).map(cita -> {
            cita.setFechaHora(citaActualizada.getFechaHora());
            cita.setMotivo(citaActualizada.getMotivo());
            cita.setEstado(citaActualizada.getEstado());
            cita.setPaciente(citaActualizada.getPaciente());
            cita.setMedico(citaActualizada.getMedico());
            return citaMedicaRepository.save(cita);
        }).orElseThrow(() -> new RuntimeException("Cita no encontrada"));
    }

    public void eliminar(Integer id) {
        citaMedicaRepository.deleteById(id);
    }
}