package com.GestionHospitalaria.demo.medicos.model;

import com.GestionHospitalaria.demo.especialidades.model.Especialidad;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "medicos")
@Data
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String gmail;

    @ManyToOne
    @JoinColumn(name = "especialidad_id", nullable = false)
    private Especialidad especialidad;
}