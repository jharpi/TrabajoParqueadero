package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarroTest {

    private Carro carro;

    @BeforeEach
    public void setUp() {
        carro = new Carro("ABC123", "Toyota", "Juan Perez");
    }

    @Test
    public void testGetPlaca() {
        assertEquals("ABC123", carro.getPlaca());
    }

    @Test
    public void testGetModelo() {
        assertEquals("Toyota", carro.getModelo());
    }

    @Test
    public void testGetPropietario() {
        assertEquals("Juan Perez", carro.getPropietario());
    }

    @Test
    public void testGetTipo() {
        // Parqueadero TIPO_CARRO= 1
        assertEquals(1, carro.getTipo());
    }
}
