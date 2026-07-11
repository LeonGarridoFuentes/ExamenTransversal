package com.GestionHospitalaria.demo.fichasClinicas.model;

import com.GestionHospitalaria.demo.pacientes.model.Paciente;
import com.GestionHospitalaria.demo.medicos.model.Medico;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "fichas_clinicas")
@JsonPropertyOrder({ "idFicha", "fechaRegistro", "diagnostico", "tratamiento", "paciente", "medico" })
public class FichaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Integer idFicha;

    @Column(nullable = false)
    private LocalDate fechaRegistro;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String diagnostico;

    @Column(columnDefinition = "TEXT")
    private String tratamiento;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_medico", nullable = false)
    private Medico medico;
}