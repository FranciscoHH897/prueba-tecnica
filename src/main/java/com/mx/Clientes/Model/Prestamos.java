package com.mx.Clientes.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Prestamos {
    @Id
    private String id;

    private double monto;

    private String clienteId;

    private LocalDate fecha;

    @Enumerated(EnumType.STRING) // Esto permite que el enum se almacene como texto en la BD
    private Estado estado;
}
