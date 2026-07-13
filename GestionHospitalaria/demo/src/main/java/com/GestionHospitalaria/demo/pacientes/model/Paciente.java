package com.GestionHospitalaria.demo.pacientes.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pacientes")
@JsonPropertyOrder({ "idPaciente", "nombre", "apellido", "rut" })
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY)
    @Column(name = "id_paciente")
    private Integer idPaciente;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "rut")
    private String rut;
}