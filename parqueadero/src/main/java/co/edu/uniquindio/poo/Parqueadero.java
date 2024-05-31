package co.edu.uniquindio.poo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Parqueadero {
    private Vehiculo[][] puestos; /*Matriz que representa los puestos*/
    private Map<String, LocalDateTime> registroEntradas; /* registra las horas de entrada de los vehículos según su placa */
    private Map<Integer, Double> tarifas;

    /*almacenan las tarifas por hora, dia y mes para los vehiculos*/
    private Map<Integer, Double> tarifasPorHora;
    private Map<Integer, Double> tarifasDiarias;
    private Map<Integer, Double> tarifasMensuales;
    private Map<Integer, Double> ingresosMensuales;/*registra los ingresos mensuales del parqueadero */
    private int filas;
    private int columnas;

    public static final Integer TIPO_CARRO = 1;
    public static final Integer TIPO_MOTO_CLASICA = 2;
    public static final Integer TIPO_MOTO_HIBRIDA = 3;

/*Constructor que inicializa los mapas */
    public Parqueadero(int filas, int columnas) {
        puestos = new Vehiculo[filas][columnas];
        tarifas = new HashMap<>();
        registroEntradas = new HashMap<>();
        tarifasPorHora = new HashMap<>();
        tarifasDiarias = new HashMap<>();
        tarifasMensuales = new HashMap<>();
        ingresosMensuales = new HashMap<>();
        this.filas = filas; /*Asignar número de filas */
        this.columnas = columnas; /*Asignar número de columnas */
    }
/*Métodos para obtener el número de filas y columnas */
    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

/*Metodos para obtener los mapas correspondientes */
    public Map<Integer, Double> getTarifas() {
        return tarifas;
    }

    public Map<Integer, Double> getTarifasDiarias() {
        return tarifasDiarias;
    }

    public Map<Integer, Double> getTarifasMensuales() {
        return tarifasMensuales;
    }

// Métodos para establecer la tarifa
    public void setTarifaPorHora(int tipoVehiculo, double tarifaPorHora) {
        tarifasPorHora.put(tipoVehiculo, tarifaPorHora);
    }

    public void setTarifaDiaria(int tipoVehiculo, double tarifasDiaria) {
        tarifasDiarias.put(tipoVehiculo, tarifasDiaria);
    }

    public void setTarifaMensual(int tipoVehiculo, double tarifasMensual) {
        tarifasMensuales.put(tipoVehiculo, tarifasMensual);
    }

    public boolean puestoDisponible(int fila, int columna) { /*// verificar si un puesto está libre en una fila y columna específicas */
        return puestos[fila][columna] == null;
    }
    
    public Map < Integer,Double > getTarifasPorHora() {// obtener el mapa de tarifas por hora 
        return tarifasPorHora;
    }

    /*Método para estacionar un vehículo en un puesto específico  */
    public boolean estacionarVehiculo(Vehiculo vehiculo, int fila, int columna) {
        if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
            System.out.println("La posición especificada está fuera de los límites del parqueadero.");
            return false;
        }
        if (!puestoDisponible(fila, columna)) {
            System.out.println("El puesto está ocupado."); /*Verificar si el puesto está ocupado */
            return false;
        }
        String placa = vehiculo.getPlaca();
        if (!validarFormatoPlaca(placa)) { /*Verificar el nombre del propietario del vehículo */
            System.out.println("La placa del vehículo debe tener el formato ABC123");
            return false;
        }
        String propietario = vehiculo.getPropietario();
        if (!validarNombrePropietario(propietario)) {
            System.out.println("El nombre del propietario del vehículo solo puede contener letras");
            return false;
        }

        /*Estacionar el vehículo en el puesto especificado y registrar la hora entrada */
        puestos[fila][columna] = vehiculo; 
        registroEntradas.put(vehiculo.getPlaca(), LocalDateTime.now());
        return true;
    }
/*Verifica si la placa no es nula y coincide*/
    private boolean validarNombrePropietario(String propietario) {
        return propietario != null && propietario.matches("[a-zA-Z\\s]+");
    }

    private boolean validarFormatoPlaca(String placa) {
        return placa != null && placa.matches("[A-Z]{3}\\d{3}");
    }

    public Vehiculo desocuparPuesto(int fila, int columna) { /*Método para desocupar un puesto especifico*/
        Vehiculo vehiculo = puestos[fila][columna];
        puestos[fila][columna] = null;
        return vehiculo;
    }

    /*registrar la salida de un vehículo y calcular el costo de la estadía */
    public double registrarSalida(String placa) {
        LocalDateTime horaEntrada = registroEntradas.get(placa);
        LocalDateTime horaSalida = LocalDateTime.now();

        /* Buscar el vehículo en el parqueadero */
        for (Vehiculo[] fila : puestos) {
            for (Vehiculo vehiculo : fila) {
                if (vehiculo != null && vehiculo.getPlaca().equals(placa)) {
                    int tipoVehiculo = vehiculo.getTipo();
                    double costo = calcularCostoEstadia(horaEntrada, horaSalida, tipoVehiculo); /*Calcular el costo de la estadía */
                    return costo;
                }
            }
        }
        System.out.println("Error: No se encontró el vehículo con la placa especificada.");
        return 0.0;
    }

    public String identificarPropietario(int fila, int columna) { /*identificar el propietario en un puesto especifico */
        return puestos[fila][columna] != null ? puestos[fila][columna].getPropietario() : null;
    }

    public void registrarIngreso(Vehiculo vehiculo, int filas, int columnas) {
        registroEntradas.put(vehiculo.getPlaca(), LocalDateTime.now());
    }

    public Map<String, LocalDateTime> getRegistroEntradas() {
        return registroEntradas;
    }
/*costo de la estadía de un vehículo según el tiempo transcurrido y el tipo de vehículo */
    public double calcularCostoEstadia(LocalDateTime horaEntrada, LocalDateTime horaSalida, int tipoVehiculo) {
        Duration tiempoTranscurrido = Duration.between(horaEntrada, horaSalida);
        long horas = tiempoTranscurrido.toHours();

        double tarifaHora = tarifas.getOrDefault(tipoVehiculo, 0.0);

        return horas * tarifaHora;
    }

    public void setTarifas(int tipoVehiculo, double tarifa) {/*establecer las tarifas por tipo de vehículo */
        tarifas.put(tipoVehiculo, tarifa);
    }

    /*calcular el costo de estacionamiento de un vehículo con una placa específica durante X numero de horas */
    public double calcularcosto(String placa, int horas) {
        LocalDateTime horaEntrada = registroEntradas.get(placa);
        LocalDateTime horaSalida = horaEntrada.plusHours(horas);
        Vehiculo vehiculo = puestos[0][0];
        int tipoVehiculo = vehiculo.getTipo();
        return calcularCostoEstadia(horaEntrada, horaSalida, tipoVehiculo);
    }

    public Map<Integer, Double> generarReporteDiario() {
        Map<Integer, Double> reporteDiario = new HashMap<>();/*mapa para almacenar el reporte diario de ingresos por tipo de vehículo */

        for (Map.Entry<String, LocalDateTime> entry : registroEntradas.entrySet()) {
            String placa = entry.getKey();
            LocalDateTime horaEntrada = entry.getValue();
            LocalDateTime horaSalida = LocalDateTime.now();
            Duration tiempoTranscurrido = Duration.between(horaEntrada, horaSalida);
            long horas = tiempoTranscurrido.toHours();

            /*Verificar que el arreglo de puestos no sea nulo y tenga elementos */
            if (puestos != null && puestos.length > 0 && puestos[0].length > 0) {

                /*Recorrer todos los puestos del parqueadero */
                for (int i = 0; i < puestos.length; i++) {
                    for (int j = 0; j < puestos[0].length; j++) {
                        Vehiculo vehiculo = puestos[i][j];
                        if (vehiculo != null && vehiculo.getPlaca().equals(placa)) {/*Verificar que el puesto no esté vacío y que la placa del vehículo coincida */
                            double total = reporteDiario.getOrDefault(vehiculo.getTipo(), 0.0);/* Obtener el total acumulado para el tipo de vehículo*/
                            double tarifaPorHora = tarifasPorHora.getOrDefault(vehiculo.getTipo(), 0.0); /*tarifa por hora */
                            double tarifaDiaria = tarifasDiarias.getOrDefault(vehiculo.getTipo(), 0.0);/*tarifa por dia */
                            total += horas * tarifaPorHora + tarifaDiaria;/*Calcular el total sumando las tarifas multiplicadas por el número de horas */
                            reporteDiario.put(vehiculo.getTipo(), total);/*Actualizar el total en el reporte diario */
                        }
                    }
                }
            } else {/*si el puesto es nulo o no tiene elementos, */
                System.out.println("Error: No se pudo generar el reporte Diario. No hay información de puestos disponibles");
                return null;
            }
        }
        return reporteDiario;
    }

    public Map<Integer, Double> generarReporteMensual() { /*mapa para almacenar reporte mensual */
        Map<Integer, Double> reporteMensual = new HashMap<>();

        for (Map.Entry<String, LocalDateTime> entry : registroEntradas.entrySet()) {
            String placa = entry.getKey();
            LocalDateTime horaEntrada = entry.getValue(); /*Obtener la placa del vehículo clave- valor */
            LocalDateTime horaSalida = LocalDateTime.now();/*Establecer la hora de salida actual */
            Duration tiempoTranscurrido = Duration.between(horaEntrada, horaSalida);/* Calcular la duración de la estadía */
            long diasEstadia = tiempoTranscurrido.toDays(); /*Convertir la duración a días */

            if (diasEstadia > 0) {
                Vehiculo vehiculo = buscarVehiculoPorPlaca(placa);/* buscar vehiculo por placa */
                if (vehiculo != null) {
                    double total = reporteMensual.getOrDefault(vehiculo.getTipo(), 0.0);/* Obtener el total acumulado para el tipo de vehículo */

                    if (diasEstadia == 1) {/*Si la estadía es de un día, aplicar la tarifa diaria */
                        double tarifaDiaria = tarifasDiarias.getOrDefault(vehiculo.getTipo(), 0.0);
                        total += tarifaDiaria;
                    } else {
                        double tarifaMensual = tarifasMensuales.getOrDefault(vehiculo.getTipo(), 0.0); /*Si la estadía es de más de un día, aplicar la tarifa mensual */
                        total += tarifaMensual;
                    }
                    reporteMensual.put(vehiculo.getTipo(), total);
                }
            }
        }
        return reporteMensual;
    }

    public double obtenerIngresosMensuales(int mes) { /*obtener los ingresos mensuales para un mes específico */
        return ingresosMensuales.getOrDefault(mes, 0.0);
    }

    public Vehiculo buscarVehiculoPorPlaca(String placa) { /*buscar un vehículo por su placa */
        for (Vehiculo[] fila : puestos) {
            for (Vehiculo vehiculo : fila) {
                if (vehiculo != null && vehiculo.getPlaca().equals(placa)) {
                    return vehiculo;
                }
            }
        }
        return null;
    }
}