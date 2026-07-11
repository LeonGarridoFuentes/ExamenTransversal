package com.GestionHospitalaria.demo.recetas.model;

import com.GestionHospitalaria.demo.pacientes.model.Paciente;
import com.GestionHospitalaria.demo.medicos.model.Medico;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "recetas")
@JsonPropertyOrder({ "idReceta", "fechaEmision", "medicamento", "posologia", "paciente", "medico" })
public class Receta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Integer idReceta;

    @Column(nullable = false)
    private LocalDate fechaEmision;

    @Column(nullable = false, length = 150)
    private String medicamento;

    @Column(nullable = false, length = 255)
    private String posologia;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_medico", nullable = false)
    private Medico medico;
}