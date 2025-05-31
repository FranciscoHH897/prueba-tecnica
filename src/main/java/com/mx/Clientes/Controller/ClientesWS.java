package com.mx.Clientes.Controller;

import ch.qos.logback.core.net.server.Client;
import com.mx.Clientes.Model.Clientes;
import com.mx.Clientes.Service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Clientes")
public class ClientesWS {

    @Autowired
    private ClientesService service;

    @GetMapping
    public ResponseEntity<?> listarClientes() {
        List<Clientes> clientes = service.listarClientes();
        if (clientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(clientes);
        }
    }

    @PostMapping
    public ResponseEntity<?> agregarCliente(@RequestBody Clientes cliente) {
        Clientes aux = service.buscarCliente(cliente.id());
        if (aux!=null) {
            return ResponseEntity.badRequest().body("El cliente ya existe");
        }else{
            service.agregarCliente(cliente);
            return ResponseEntity.ok().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarCliente(@PathVariable String id, @RequestBody Clientes cliente) {
        Clientes aux = service.buscarCliente(cliente.id());
        if (aux!=null) {
            service.actualizarCliente(cliente.id(),cliente.email(),cliente.tipoCliente());
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().body("El cliente no existe");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCliente(@PathVariable String id) {
        Clientes aux = service.buscarCliente(id);
        if (aux!=null) {
            service.eliminarCliente(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().body("El cliente no existe");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerDescuento(@PathVariable String id) {
        double descuento = service.obtenerDescuento(id);
        return ResponseEntity.ok(descuento);
    }
}
