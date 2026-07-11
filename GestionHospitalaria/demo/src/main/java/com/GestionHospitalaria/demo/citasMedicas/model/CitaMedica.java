package com.GestionHospitalaria.demo.citasMedicas.model;

import com.GestionHospitalaria.demo.pacientes.model.Paciente;
import com.GestionHospitalaria.demo.medicos.model.Medico;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "citas_medicas")
@JsonPropertyOrder({ "idCita", "fechaHora", "motivo", "estado", "paciente", "medico" })
public class CitaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Integer idCita;

    @Column(nullable = false)
    private Date fechaHora;

    @Column(length = 255)
    private String motivo;

    @Column(length = 50)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_medico", nullable = false)
    private Medico medico;
}