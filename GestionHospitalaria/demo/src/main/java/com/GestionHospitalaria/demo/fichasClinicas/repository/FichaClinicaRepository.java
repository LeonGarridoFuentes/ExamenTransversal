package com.GestionHospitalaria.demo.fichasClinicas.repository;

import com.GestionHospitalaria.demo.fichasClinicas.model.FichaClinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FichaClinicaRepository extends JpaRepository<FichaClinica, Integer> {
}