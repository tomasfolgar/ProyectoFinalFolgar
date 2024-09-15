package edu.coder.preentrega.service;


import edu.coder.preentrega.Producto;
import edu.coder.preentrega.repository.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public Producto agregarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Optional<Producto> buscarProducto(Long id) {
        return productoRepository.findById(id);
    }

    public boolean eliminarProducto(Long id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Producto modificarProducto(Long id, Producto producto) {

        if (productoRepository.existsById(id)) {


            Producto productoExistente = productoRepository.findById(id).orElse(null);
            if (productoExistente != null) {

                productoExistente.setNombre_producto(producto.getNombre_producto());
                productoExistente.setPrecio(producto.getPrecio());
                productoExistente.setStock(producto.getStock());

                productoExistente.setNombre_producto(producto.getNombre_producto());


                return productoRepository.save(productoExistente);
            } else {
                throw new RuntimeException("Producto no encontrado");
            }
        } else {
            throw new RuntimeException("Producto no encontrado");
        }
    }
}
