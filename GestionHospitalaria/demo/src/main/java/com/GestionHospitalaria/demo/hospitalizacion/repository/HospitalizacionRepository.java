package com.GestionHospitalaria.demo.hospitalizacion.repository;

import com.GestionHospitalaria.demo.hospitalizacion.model.Hospitalizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalizacionRepository extends JpaRepository<Hospitalizacion, Integer> {
}