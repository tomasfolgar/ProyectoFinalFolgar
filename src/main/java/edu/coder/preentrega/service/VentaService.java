package edu.coder.preentrega.service;


import edu.coder.preentrega.Venta;
import edu.coder.preentrega.repository.VentaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;

    public Venta agregarVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    public Optional<Venta> buscarVenta(Long id) {
        return ventaRepository.findById(id);
    }

    public boolean eliminarVenta(Long id) {

        if (ventaRepository.existsById(id)) {
            ventaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Venta modificarVenta(Long id, Venta venta) {

        if (ventaRepository.existsById(id)) {


            Venta ventaExistente = ventaRepository.findById(id).orElse(null);


            if (ventaExistente != null) {
                ventaExistente.setCliente(venta.getCliente());
                ventaExistente.setMonto(venta.getMonto());
                ventaExistente.setFecha(venta.getFecha());


                ventaExistente.setCliente(venta.getCliente());
                ventaExistente.setMonto(venta.getMonto());


                return ventaRepository.save(ventaExistente);
            } else {
                throw new RuntimeException("Venta no encontrada");
            }
        } else {
            throw new RuntimeException("Venta no encontrada");
        }
    }
}
