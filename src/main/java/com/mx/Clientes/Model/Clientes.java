package com.mx.Clientes.Model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

public record Clientes(
        @NotBlank String id,
        @NotBlank String nombre,
        @Email String email,
        @Min(18) int edad,
        TipoCliente tipoCliente
) {}



