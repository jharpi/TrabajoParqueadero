package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VehiculoTest {

    private Vehiculo vehiculo;

    @BeforeEach
    public void setUp() {
        vehiculo = new Carro("ABC123", "Toyota", "Juan Perez");
    }

    @Test
    public void testGetPlaca() {
        assertEquals("ABC123", vehiculo.getPlaca());
    }

    @Test
    public void testGetModelo() {
        assertEquals("Toyota", vehiculo.getModelo());
    }

    @Test
    public void testGetPropietario() {
        assertEquals("Juan Perez", vehiculo.getPropietario());
    }

    @Test
    public void testGetTipo() {
        assertEquals(1, vehiculo.getTipo()); // Verificando que el tipo es 1 para Carro
    }
}   