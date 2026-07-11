package com.GestionHospitalaria.demo.urgencias.model;

import com.GestionHospitalaria.demo.pacientes.model.Paciente;
import com.GestionHospitalaria.demo.medicos.model.Medico;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "urgencias")
@JsonPropertyOrder({ "idUrgencia", "fechaHoraIngreso", "triage", "motivoConsulta", "paciente", "medico" })
public class Urgencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Integer idUrgencia;

    @Column(nullable = false)
    private Date fechaHoraIngreso;

    @Column(nullable = false, length = 30)
    private String triage;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String motivoConsulta;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_medico", nullable = false)
    private Medico medico;
}