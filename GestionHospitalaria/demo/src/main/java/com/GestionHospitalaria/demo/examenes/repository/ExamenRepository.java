package com.GestionHospitalaria.demo.examenes.repository;

import com.GestionHospitalaria.demo.examenes.model.Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamenRepository extends JpaRepository<Examen, Integer> {
}