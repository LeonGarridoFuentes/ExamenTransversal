package com.GestionHospitalaria.demo.hospitalizacion.model;

import com.GestionHospitalaria.demo.pacientes.model.Paciente;
import com.GestionHospitalaria.demo.medicos.model.Medico;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "hospitalizaciones")
@JsonPropertyOrder({ "idHospitalizacion", "fechaIngreso", "fechaAlta", "numCama", "paciente", "medico" })
public class Hospitalizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Integer idHospitalizacion;

    @Column(nullable = false)
    private LocalDate fechaIngreso;

    private LocalDate fechaAlta;

    @Column(nullable = false, length = 10)
    private String numCama;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_medico", nullable = false)
    private Medico medico;
}