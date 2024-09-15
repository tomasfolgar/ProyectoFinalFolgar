package edu.coder.preentrega.controller;

import edu.coder.preentrega.Producto;
import edu.coder.preentrega.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @PostMapping("/agregar")
    public Producto agregarProducto(@RequestBody Producto producto) {
        return productoService.agregarProducto(producto);
    }

    @GetMapping("/buscar/{id}")
    public Optional<Producto> buscarProducto(@PathVariable Long id) {
        return productoService.buscarProducto(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        boolean eliminado = productoService.eliminarProducto(id);
        if (eliminado) {
            return "Producto eliminado con éxito.";
        }
        else {
            return "No se encontró el producto con ID: " + id;
        }
    }
    @PutMapping("/modificar/{id}")
    public Producto modificarProducto(@PathVariable Long id, @RequestBody Producto producto) {
        return productoService.modificarProducto(id, producto);
    }
}

