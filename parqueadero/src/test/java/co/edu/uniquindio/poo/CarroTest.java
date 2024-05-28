package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarroTest {

    private Carro carro;

    @BeforeEach
    public void setUp() { /*setUP sE ejecuta antes de cada prueba para inicializar un objeto Carro con valores predefinidos. */
        carro = new Carro("TRT123", "Renault", "Miguel");
    }

    @Test
    public void testGetPlaca() {
        assertEquals("TRT123", carro.getPlaca());/*Verifica que el método getPlaca  devuelva la placa correcta ("TRT123"). */
    }

    @Test
    public void testGetModelo() {
        assertEquals("Renault", carro.getModelo());/*devuelva el modelo correcto */
    }

    @Test
    public void testGetPropietario() {
        assertEquals("Miguel", carro.getPropietario());/*devuelva el propietario correcto */
    }

    @Test
    public void testGetTipo() {
        // Parqueadero TIPO_CARRO= 1
        assertEquals(1, carro.getTipo());
    }/* Verifica que el método getTipo de la clase Carro devuelva el tipo correcto (Carro=1). */
}
