package com.GestionHospitalaria.demo.hospitalizacion.service;

import com.GestionHospitalaria.demo.hospitalizacion.model.Hospitalizacion;
import com.GestionHospitalaria.demo.hospitalizacion.repository.HospitalizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HospitalizacionService {

    @Autowired
    private HospitalizacionRepository hospitalizacionRepository;

    public List<Hospitalizacion> listar() {
        return hospitalizacionRepository.findAll();
    }

    public Hospitalizacion guardar(Hospitalizacion hosp) {
        return hospitalizacionRepository.save(hosp);
    }

    public Hospitalizacion actualizar(Integer id, Hospitalizacion hospAct) {
        return hospitalizacionRepository.findById(id).map(hosp -> {
            hosp.setFechaIngreso(hospAct.getFechaIngreso());
            hosp.setFechaAlta(hospAct.getFechaAlta());
            hosp.setNumCama(hospAct.getNumCama());
            hosp.setPaciente(hospAct.getPaciente());
            hosp.setMedico(hospAct.getMedico());
            return hospitalizacionRepository.save(hosp);
        }).orElseThrow(() -> new RuntimeException("Registro de hospitalización no encontrado"));
    }

    public void eliminar(Integer id) {
        hospitalizacionRepository.deleteById(id);
    }
}