package edu.coder.preentrega.controller;

import edu.coder.preentrega.Cliente;
import edu.coder.preentrega.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/agregar")
    public Cliente agregarCliente(@RequestBody Cliente cliente) {
        return clienteService.agregarCliente(cliente);
    }

    @GetMapping("/buscar/{id}")
    public Optional<Cliente> buscarCliente(@PathVariable Long id) {
        return clienteService.buscarCliente(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        boolean eliminado = clienteService.eliminarCliente(id);
        if (eliminado) {
            return "Cliente eliminado con éxito.";
        }
        else {


        return "No se encontró el cliente con ID: " + id;
    }}

    @PutMapping("/modificar/{id}")
    public Cliente modificarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.modificarCliente(id, cliente);
    }

}


