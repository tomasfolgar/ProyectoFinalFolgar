package edu.coder.preentrega.service;


import edu.coder.preentrega.Cliente;
import edu.coder.preentrega.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente agregarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> buscarCliente(Long id) {
        return clienteRepository.findById(id);
    }

    public boolean eliminarCliente(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Cliente modificarCliente(Long id, Cliente cliente) {

        if (clienteRepository.existsById(id)) {

            Cliente clienteExistente = clienteRepository.findById(id).orElse(null);
            if (clienteExistente != null) {

                clienteExistente.setNombre(cliente.getNombre());
                clienteExistente.setApellido(cliente.getApellido());
                clienteExistente.setDni(cliente.getDni());

                clienteExistente.setNombre(cliente.getNombre());
                clienteExistente.setApellido(cliente.getApellido());

                return clienteRepository.save(clienteExistente);
            } else {
                throw new RuntimeException("Cliente no encontrado");
            }
        }

        else {
            throw new RuntimeException("Cliente no encontrado");
        }
    }

}