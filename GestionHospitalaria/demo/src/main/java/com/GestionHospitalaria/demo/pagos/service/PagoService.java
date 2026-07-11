package com.GestionHospitalaria.demo.pagos.service;

import com.GestionHospitalaria.demo.pagos.model.Pago;
import com.GestionHospitalaria.demo.pagos.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    public List<Pago> listar() {
        return pagoRepository.findAll();
    }

    public Pago guardar(Pago pago) {
        return pagoRepository.save(pago);
    }

    public Pago actualizar(Integer id, Pago pagoAct) {
        return pagoRepository.findById(id).map(pago -> {
            pago.setMonto(pagoAct.getMonto());
            pago.setFechaPago(pagoAct.getFechaPago());
            pago.setMetodoPago(pagoAct.getMetodoPago());
            pago.setPaciente(pagoAct.getPaciente());
            return pagoRepository.save(pago);
        }).orElseThrow(() -> new RuntimeException("Pago no encontrado"));
    }

    public void eliminar(Integer id) {
        pagoRepository.deleteById(id);
    }
}