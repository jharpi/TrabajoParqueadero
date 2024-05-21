package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MotoTest {

    private Moto moto;

    @BeforeEach
    public void setUp() {
        moto = new Moto("DBC123", "TTR", "Ricardo", 150);
    }

    @Test
    public void testGetPlaca() {
        assertEquals("DBC123", moto.getPlaca());
    }

    @Test
    public void testGetModelo() {
        assertEquals("TTR", moto.getModelo());
    }

    @Test
    public void testGetPropietario() {
        assertEquals("Ricardo", moto.getPropietario());
    }

    @Test
    public void testGetVelocidadMaxima() {
        assertEquals(150, moto.getVelocidadMaxima());
    }

    @Test
    public void testGetTipo() {
        // Parqueadero.TIPO_MOTO_CLASICA= 2
        assertEquals(2, moto.getTipo());
    }
}
