package com.GestionHospitalaria.demo.urgencias.repository;

import com.GestionHospitalaria.demo.urgencias.model.Urgencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrgenciaRepository extends JpaRepository<Urgencia, Integer> {
}