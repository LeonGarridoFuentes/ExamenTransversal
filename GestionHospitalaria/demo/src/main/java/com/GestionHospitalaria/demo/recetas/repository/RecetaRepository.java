package com.GestionHospitalaria.demo.recetas.repository;

import com.GestionHospitalaria.demo.recetas.model.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetaRepository extends JpaRepository<Receta, Integer> {
}