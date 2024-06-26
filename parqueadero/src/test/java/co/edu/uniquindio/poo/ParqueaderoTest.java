package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParqueaderoTest {

    private Parqueadero parqueadero;

    //-----------------------------------------------------------------------------------------------------------------------------------------------------//
    @BeforeEach
    public void setUp() {
        parqueadero = new Parqueadero(6, 6); // Crear un parqueadero con 6 filas y 6 columnas para las pruebas
        parqueadero.setTarifaPorHora(Parqueadero.TIPO_CARRO, 5000); // Tarifa por hora para carros: $5
        parqueadero.setTarifaPorHora(Parqueadero.TIPO_MOTO_CLASICA, 3000); // Tarifa por hora para motos clásicas: $3
        parqueadero.setTarifaPorHora(Parqueadero.TIPO_MOTO_HIBRIDA, 3500); // Tarifa por hora para motos híbridas: $4
    }
     //------------------------------------------------------------------------------------------------------------------------------------------------------//

     @Test
     public void testSetTarifaPorHora() {/*verifica que el método setTarifaPorHora establece la tarifa correcta por hora para carros. */
         parqueadero.setTarifaPorHora(Parqueadero.TIPO_CARRO, 5000);
         assertEquals(5000, parqueadero.getTarifasPorHora().get(Parqueadero.TIPO_CARRO));
     }

     @Test
     public void testSetTarifaDiaria() {/*Verifica que el método setTarifaDiaria establece la tarifa diaria correcta para carros. */
         parqueadero.setTarifaDiaria(Parqueadero.TIPO_CARRO, 10000);
         assertEquals(10000, parqueadero.getTarifasDiarias().get(Parqueadero.TIPO_CARRO));
     }

     @Test
    public void testSetTarifaMensual() {/*Verifica que el método  establezca  la tarifa mensual correcta para carros. */
        parqueadero.setTarifaMensual(Parqueadero.TIPO_CARRO, 30000);
      
        assertEquals(30000, parqueadero.getTarifasMensuales().get(Parqueadero.TIPO_CARRO));
    }
    @Test
    public void testGetTarifasPorHora() {/* Verifica que se puede obtener correctamente la tarifa por hora para motos clásicas. */
        parqueadero.setTarifaPorHora(Parqueadero.TIPO_MOTO_CLASICA, 3000);
        assertEquals(3000, parqueadero.getTarifasPorHora().get(Parqueadero.TIPO_MOTO_CLASICA));
    }

    @Test
    public void testGetTarifasDiarias() {/*Verifica que se puede obtener correctamente la tarifa diaria para motos clásicas. */
        parqueadero.setTarifaDiaria(Parqueadero.TIPO_MOTO_CLASICA, 8000);
        assertEquals(8000, parqueadero.getTarifasDiarias().get(Parqueadero.TIPO_MOTO_CLASICA));
    }

    @Test
    public void testGetTarifasMensuales() {/*Verifica que se puede obtener correctamente la tarifa mensual */
        parqueadero.setTarifaMensual(Parqueadero.TIPO_MOTO_CLASICA, 20000);
        assertEquals(20000, parqueadero.getTarifasMensuales().get(Parqueadero.TIPO_MOTO_CLASICA));
    }

     //------------------------------------------------------------------------------------------------------------------------------------------------------//

     @Test
    public void testPuestoDisponibleCuandoParqueaderoVacio() {
        assertTrue(parqueadero.puestoDisponible(0, 0));  
    }
/*Verifica que un puesto está disponible cuando el parqueadero está vacío. */
//------------------------------------------------------------------------------------------------------------------------------------------------------//    

    @Test
    public void testDesocuparPuesto_Empty() {
    assertNull(parqueadero.desocuparPuesto(0, 0)); 
    }/* Verifica que el método desocuparPuesto retorna null cuando se intenta desocupar un puesto vacío. */

    @Test
        public void calcularCostoEstadia_CalculaCorrectamenteCostoHora() {

            Parqueadero parqueadero = new Parqueadero(5, 5);
            double tarifaHora = 1000; 
            parqueadero.setTarifas(Parqueadero.TIPO_CARRO, tarifaHora);
            LocalDateTime horaEntrada = LocalDateTime.of(2024, 5, 15, 10, 0); 
            LocalDateTime horaSalida = LocalDateTime.of(2024, 5, 15, 12, 0); 
            
            double costo = parqueadero.calcularCostoEstadia(horaEntrada, horaSalida, Parqueadero.TIPO_CARRO);

            assertEquals(2000, costo, 0.01); 
    } /*Verifica que el costo de estadía por hora se calcula correctamente para un carro. */

    @Test
    public void calcularCostoEstadia_MotoClasica_CalculaCorrectamenteCostoHora() {
        Parqueadero parqueadero = new Parqueadero(5, 5);
        double tarifaHoraMotoClasica = 800; 
        parqueadero.setTarifas(Parqueadero.TIPO_MOTO_CLASICA, tarifaHoraMotoClasica);
        LocalDateTime horaEntrada = LocalDateTime.of(2024, 5, 15, 10, 0);
        LocalDateTime horaSalida = LocalDateTime.of(2024, 5, 15, 12, 0);
        
        double costo = parqueadero.calcularCostoEstadia(horaEntrada, horaSalida, Parqueadero.TIPO_MOTO_CLASICA);

        assertEquals(1600, costo, 0.01); 
    } /*Verifica que el costo de estadía por hora se calcula correctamente para una moto clásica. */

    @Test
    public void calcularCostoEstadia_MotoHibrida_CalculaCorrectamenteCostoHora() {
        Parqueadero parqueadero = new Parqueadero(5, 5);
        double tarifaHoraMotoHibrida = 600;
        parqueadero.setTarifas(Parqueadero.TIPO_MOTO_HIBRIDA, tarifaHoraMotoHibrida);
        LocalDateTime horaEntrada = LocalDateTime.of(2024, 5, 15, 10, 0);
        LocalDateTime horaSalida = LocalDateTime.of(2024, 5, 15, 12, 0);
        
        double costo = parqueadero.calcularCostoEstadia(horaEntrada, horaSalida, Parqueadero.TIPO_MOTO_HIBRIDA);

        assertEquals(1200, costo, 0.01);
    }/*Verifica que el costo de estadía por hora se calcula correctamente para una moto híbrida. */
//------------------------------------------------------------------------------------------------------------------------------------------------------//
    @Test
    public void testGenerarReporteDiario_SinVehiculos() {
        Map<Integer, Double> reporteDiario = parqueadero.generarReporteDiario();
        assertTrue(reporteDiario.isEmpty(), "El reporte diario debería estar vacío cuando no hay vehículos estacionados.");
    }/*Verifica que el reporte diario está vacío cuando no hay vehículos estacionados. */
//------------------------------------------------------------------------------------------------------------------------------------------------------//

    @Test
    public void testGenerarReporteMensual_SinVehiculos() {
        Map<Integer, Double> reporteMensual = parqueadero.generarReporteMensual();
        assertTrue(reporteMensual.isEmpty(), "El reporte mensual debería estar vacío cuando no hay vehículos estacionados.");
    }/*Verifica que el reporte mensual está vacío cuando no hay vehículos estacionados. */

    @Test
    public void testBuscarVehiculoPorPlaca_VehiculoNoExistente() {
 
        String placa = "TRT123";
        Vehiculo vehiculo = parqueadero.buscarVehiculoPorPlaca(placa);
        assertNull(vehiculo, "No debería encontrarse un vehículo con la placa " + placa);
    }/*Verifica que el método buscarVehiculoPorPlaca no encuentra un vehículo con una placa inexistente. */
    
}