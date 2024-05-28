package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VehiculoTest {

    private Vehiculo vehiculo;

    @BeforeEach
    public void setUp() {/*setUP sE ejecuta antes de cada prueba para inicializar un objeto Carro con valores predefinidos. */
        vehiculo = new Carro("TRT123", "Renault", "Miguel");
    }

    @Test
    public void testGetPlaca() {
        assertEquals("TRT123", vehiculo.getPlaca());/*verifica que el metodo GetPlaca devuelva el modelo correcto */
    }

    @Test
    public void testGetModelo() {
        assertEquals("FZ", vehiculo.getModelo());/*verifica que el metodo GetModelo devuelva el modelo correcto */
    }

    @Test
    public void testGetPropietario() {
        assertEquals("Miguel", vehiculo.getPropietario());/*verifica que el metodo GetPropietario devuelva el modelo correcto */
    }

    @Test
    public void testGetTipo() {
        assertEquals(1, vehiculo.getTipo()); 
    }/* Verifica que el método getTipo de la clase Carro devuelva el tipo correcto (Carro=1). */
}   