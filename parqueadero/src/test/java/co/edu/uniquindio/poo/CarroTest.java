package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarroTest {

    private Carro carro;

    @BeforeEach
    public void setUp() {
        carro = new Carro("TRT123", "Renault", "Miguel");
    }

    @Test
    public void testGetPlaca() {
        assertEquals("TRT123", carro.getPlaca());
    }

    @Test
    public void testGetModelo() {
        assertEquals("Renault", carro.getModelo());
    }

    @Test
    public void testGetPropietario() {
        assertEquals("Miguel", carro.getPropietario());
    }

    @Test
    public void testGetTipo() {
        // Parqueadero TIPO_CARRO= 1
        assertEquals(1, carro.getTipo());
    }
}
