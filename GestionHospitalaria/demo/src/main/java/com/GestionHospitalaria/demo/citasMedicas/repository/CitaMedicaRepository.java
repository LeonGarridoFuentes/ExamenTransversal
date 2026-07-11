package com.GestionHospitalaria.demo.citasMedicas.repository;

import com.GestionHospitalaria.demo.citasMedicas.model.CitaMedica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaMedicaRepository extends JpaRepository<CitaMedica, Integer> {
}