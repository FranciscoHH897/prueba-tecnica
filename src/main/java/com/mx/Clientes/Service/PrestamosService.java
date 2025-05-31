package com.mx.Clientes.Service;

import com.mx.Clientes.Model.Estado;
import com.mx.Clientes.Model.Prestamos;
import com.mx.Clientes.Model.TipoCliente;
import com.mx.Clientes.Repository.IPrestamosRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamosService {
    @Autowired
    private IPrestamosRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(PrestamosService.class);

    public List<Prestamos> listarPrestamos() {
        return repository.findByEstado(Estado.PENDIENTE);
    }

    public void crearPrestamo(Prestamos prestamo) {
        repository.save(prestamo);
        logger.info("Préstamo creado: {}", prestamo);
    }

    public void actualizarPrestamo(String id, Estado estado) {
        Prestamos prestamo = repository.findById(id).orElse(null);
        if (prestamo == null) {
            logger.info("Prestamo no encontrado");
            return;
        }else{
            prestamo.setEstado(estado);
            repository.save(prestamo);
            logger.info("Prestamo modificado: {}", prestamo);
            return;
        }
    }

    public void eliminarPrestamo(String id) {
        repository.deleteById(id);
    }

    public Prestamos buscarPrestamo(String id) {
        return repository.findById(id).orElse(null);
    }

    public double calcularPrestamoTotal(String tipo, Double prestamo) {

        if (tipo.equals("VIP")){
            return prestamo +(prestamo * 0.05);
        }else{
            return prestamo + (prestamo * 0.1);
        }

    }
}
