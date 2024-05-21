package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *Prueba unitaria para aplicación sencilla.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Crear el test
     *
     * @param testName test del nombre 
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return el conjunto de pruebas que se están probando
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * prueba rigurosa
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
