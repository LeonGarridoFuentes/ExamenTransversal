package com.GestionHospitalaria.demo.medicos.repository;

import com.GestionHospitalaria.demo.medicos.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
}