package com.mx.Clientes.Controller;


import com.mx.Clientes.Model.Clientes;
import com.mx.Clientes.Model.Prestamos;
import com.mx.Clientes.Service.ClientesService;
import com.mx.Clientes.Service.PrestamosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Prestamos")
public class PrestamosWS {

    @Autowired
    private PrestamosService service;

    @Autowired
    private ClientesService clientesService;

    @GetMapping
    public ResponseEntity<?> listarPrestamos() {
        List<Prestamos> prestamos = service.listarPrestamos();
        if(prestamos.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(prestamos);
        }
    }

    @PostMapping
    public ResponseEntity<?> crearPrestamo(@RequestBody Prestamos prestamo) {
        Prestamos aux = service.buscarPrestamo(prestamo.getId());
        if(aux == null){
            service.crearPrestamo(prestamo);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarPrestamo(@PathVariable String id, @RequestBody Prestamos prestamo) {
        Prestamos aux = service.buscarPrestamo(id);
        if(aux == null){
            return ResponseEntity.notFound().build();
        }else{
            service.actualizarPrestamo(prestamo);
            return ResponseEntity.ok().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPrestamo(@PathVariable String id) {
        Prestamos aux = service.buscarPrestamo(id);
        if(aux == null){
            return ResponseEntity.notFound().build();
        }else{
            service.eliminarPrestamo(id);
            return ResponseEntity.ok().build();
        }
    }

    @GetMapping("/calcular/{id}")
    public ResponseEntity<?> calcularPrestamo(@PathVariable String id) {
        Prestamos prestamo = service.buscarPrestamo(id);
        if(prestamo == null){
            return ResponseEntity.notFound().build();
        }else{
            Clientes cliente = clientesService.buscarCliente(prestamo.getClienteId());
            double total = service.calcularPrestamoTotal(cliente.tipoCliente().toString(), prestamo.getMonto());
            return ResponseEntity.ok().body(total);
        }
    }
}
