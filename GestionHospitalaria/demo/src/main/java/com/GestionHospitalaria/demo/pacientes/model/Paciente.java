package com.GestionHospitalaria.demo.pacientes.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pacientes")
@JsonPropertyOrder({ "idPaciente", "nombres", "apellidos", "rut" })
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPaciente;

    @Column(nullable = false, length = 50)
    private String nombres;

    @Column(nullable = false, length = 50)
    private String apellidos;

    @Column(unique = true, length = 15)
    private String rut;
}