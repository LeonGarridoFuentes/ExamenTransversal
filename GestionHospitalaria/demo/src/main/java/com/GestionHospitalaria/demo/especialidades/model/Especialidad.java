package com.GestionHospitalaria.demo.especialidades.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "especialidades")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "la especialidad no puede estar vaciA")
    @Column(unique = true, nullable = false)
    private String descripcion;
}