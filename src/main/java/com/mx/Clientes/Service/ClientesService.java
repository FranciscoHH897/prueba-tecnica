package com.mx.Clientes.Service;

import com.mx.Clientes.Model.Clientes;
import com.mx.Clientes.Model.TipoCliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientesService {

    private static final Logger logger = LoggerFactory.getLogger(ClientesService.class);

    private final List<Clientes> clientes = new ArrayList<>();

    public void agregarCliente(Clientes cliente) {
        clientes.add(cliente);
        logger.info("Se agregó el cliente: {}", cliente);
    }

    public List<Clientes> listarClientes() {
        logger.info("Obteniendo todos los clientes. Total: {}", clientes.size());
        return clientes;
    }

    public boolean actualizarCliente(String id, String nuevoEmail, TipoCliente nuevoTipo) {
        Optional<Clientes> clienteOpt = clientes.stream()
                .filter(c -> c.id().equals(id))
                .findFirst();

        if (clienteOpt.isPresent()) {
            Clientes cliente = clienteOpt.get();
            // Se crea un nuevo record con los datos actualizados
            Clientes clienteActualizado = new Clientes(cliente.id(), cliente.nombre(), nuevoEmail, cliente.edad(), nuevoTipo);
            clientes.remove(cliente);
            clientes.add(clienteActualizado);
            logger.info("Cliente actualizado con ID {}: {}", id, clienteActualizado);
            return true;
        } else {
            logger.warn("No se encontró el cliente con ID: {}", id);
            return false;
        }
    }

    public boolean eliminarCliente(String id) {
        boolean eliminado = clientes.removeIf(cliente -> cliente.id().equals(id));
        if (eliminado) {
            logger.info("Se eliminó el cliente con ID: {}", id);
        }else{
            logger.warn("No se encontró el cliente para eliminar con ID: {}", id);
        }
        return eliminado;
    }

    public double obtenerDescuento(String id) {
        Clientes aux = buscarCliente(id);
        double descuento = switch (aux.tipoCliente()) {
            case VIP -> 0.15;
            case REGULAR -> 0.0;
        };
        logger.info("Cliente {} tiene un descuento de: {}", aux.id(), descuento);
        return descuento;
    }

    public Clientes buscarCliente(String id) {
        return clientes.stream()
                .filter(cliente -> cliente.id().equals(id))
                .findFirst()
                .orElse(null);
    }
}
