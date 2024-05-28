package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VehiculoTest {

    private Vehiculo vehiculo;

    @BeforeEach
    public void setUp() {
        vehiculo = new Carro("TRT123", "Renault", "Miguel");
    }

    @Test
    public void testGetPlaca() {
        assertEquals("TRT123", vehiculo.getPlaca());
    }

    @Test
    public void testGetModelo() {
        assertEquals("FZ", vehiculo.getModelo());
    }

    @Test
    public void testGetPropietario() {
        assertEquals("Miguel", vehiculo.getPropietario());
    }

    @Test
    public void testGetTipo() {
        assertEquals(1, vehiculo.getTipo()); // Verificando que el tipo es 1 para Carro
    }
}   