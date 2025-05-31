package com.mx.Clientes;

import com.mx.Clientes.Model.Clientes;
import com.mx.Clientes.Model.TipoCliente;
import com.mx.Clientes.Service.ClientesService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
class ClientesApplicationTests {

    @InjectMocks
    private ClientesService service;
    @Test
    void testAgregarCliente() {
        Clientes cliente = new Clientes("1", "Juan Pérez", "juan@example.com", 30, TipoCliente.REGULAR);

        service.agregarCliente(cliente);

        assertEquals("tamaño correcto", service.listarClientes().size(),1);
    }

}
