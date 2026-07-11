package com.GestionHospitalaria.demo.examenes.model;

import com.GestionHospitalaria.demo.pacientes.model.Paciente;
import com.GestionHospitalaria.demo.medicos.model.Medico;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "examenes")
@JsonPropertyOrder({ "idExamen", "nombreExamen", "fechaSolicitud", "resultado", "paciente", "medico" })
public class Examen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Integer idExamen;

    @Column(nullable = false, length = 100)
    private String nombreExamen;

    @Column(nullable = false)
    private LocalDate fechaSolicitud;

    @Column(columnDefinition = "TEXT")
    private String resultado;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_medico", nullable = false)
    private Medico medico;
}