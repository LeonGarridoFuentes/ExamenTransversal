package com.GestionHospitalaria.demo.pacientes.repository;

import com.GestionHospitalaria.demo.pacientes.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}