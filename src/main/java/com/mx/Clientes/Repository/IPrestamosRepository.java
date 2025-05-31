package com.mx.Clientes.Repository;

import com.mx.Clientes.Model.Estado;
import com.mx.Clientes.Model.Prestamos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPrestamosRepository extends JpaRepository<Prestamos,String> {
    List<Prestamos> findByEstado(Estado estado);
}
