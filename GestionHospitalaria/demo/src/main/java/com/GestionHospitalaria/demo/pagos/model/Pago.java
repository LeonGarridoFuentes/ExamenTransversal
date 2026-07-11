package com.GestionHospitalaria.demo.pagos.model;

import com.GestionHospitalaria.demo.pacientes.model.Paciente;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "pagos")
@JsonPropertyOrder({ "idPago", "monto", "fechaPago", "metodoPago", "paciente" })
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Integer idPago;

    @Column(nullable = false)
    private Double monto;

    @Column(nullable = false)
    private LocalDate fechaPago;

    @Column(nullable = false, length = 50)
    private String metodoPago;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;
}