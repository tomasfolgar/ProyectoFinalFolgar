package edu.coder.preentrega.controller;

import edu.coder.preentrega.Venta;
import edu.coder.preentrega.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/ventas")
public class VentaController {
    @Autowired
    private VentaService ventaService;

    @PostMapping("/agregar")
    public Venta agregarVenta(@RequestBody Venta venta) {
        return ventaService.agregarVenta(venta);
    }

    @GetMapping("/buscar/{id}")
    public Optional<Venta> buscarVenta(@PathVariable Long id) {
        return ventaService.buscarVenta(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarVenta(@PathVariable Long id) {
        boolean eliminado = ventaService.eliminarVenta(id);

        if (eliminado) {
            return "Venta eliminada con éxito.";
        } else {
            return "No se encontró la venta con ID: " + id;
        }
    }

    @PutMapping("/modificar/{id}")
    public Venta modificarVenta(@PathVariable Long id, @RequestBody Venta venta) {
        return ventaService.modificarVenta(id, venta);
    }
}

