package co.edu.uniquindio.poo;

import java.util.Map;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static Parqueadero parqueadero;

    public static void main(String[] args) {
        System.out.println("Bienvenido al menú del parqueadero");

        parqueadero = null;

        boolean salir = false;
        while (!salir) {
            System.out.println("\nSeleccione una opción");
            System.out.println("1. Configurar Tamaño del parqueadero");
            System.out.println("2. Configurar valores de tarifas");
            System.out.println("3. Estacionar vehículo");
            System.out.println("4. Desocupar puesto");
            System.out.println("5. Identificar propietario del vehículo");
            System.out.println("6. Generar reporte diario");
            System.out.println("7. Generar reporte mensual");
            System.out.println("8. Estado del Parqueadero");
            System.out.println("9. Salir");

            int opcion = leerEntero("Ingrese el número de opción: ");

            switch (opcion) {
                case 1:
                    System.out.println("Configuración del tamaño del parqueadero");
                    int filas = leerEntero("Ingrese el número de filas del parqueadero (entre 1 y 100): ", 1, 100);
                    int columnas = leerEntero("Ingrese el número de columnas del parqueadero (entre 1 y 100): ", 1, 100);
                    parqueadero = new Parqueadero(filas, columnas);
                    break;

                case 2:
                    System.out.println("Configuración de tarifas");
                    if (parqueadero == null) {
                        System.out.println("Primero configure el tamaño del parqueadero antes de establecer las tarifas.");
                        break;
                    }

                    System.out.println("Ingrese las tarifas por hora para cada tipo de vehículo: ");
                    double tarifaHoraCarro = leerDouble("Tarifa por hora para carro: ");
                    double tarifaHoraMotoClasica = leerDouble("Tarifa por hora para moto clásica: ");
                    double tarifaHoraMotoHibrida = leerDouble("Tarifa por hora para moto híbrida: ");
                    parqueadero.setTarifaPorHora(Parqueadero.TIPO_CARRO, tarifaHoraCarro);
                    parqueadero.setTarifaPorHora(Parqueadero.TIPO_MOTO_CLASICA, tarifaHoraMotoClasica);
                    parqueadero.setTarifaPorHora(Parqueadero.TIPO_MOTO_HIBRIDA, tarifaHoraMotoHibrida);

                    System.out.println("Ingrese las tarifas diarias y mensuales para cada tipo de vehículo: ");
                    System.out.println("1. Carro");
                    double tarifaDiariaCarro = leerDouble("Tarifa diaria para carro: ");
                    double tarifaMensualCarro = leerDouble("Tarifa mensual para carro: ");
                    parqueadero.setTarifaDiaria(Parqueadero.TIPO_CARRO, tarifaDiariaCarro);
                    parqueadero.setTarifaMensual(Parqueadero.TIPO_CARRO, tarifaMensualCarro);

                    System.out.println("2. Moto Clásica");
                    double tarifaDiariaMotoClasica = leerDouble("Tarifa diaria para moto clásica: ");
                    double tarifaMensualMotoClasica = leerDouble("Tarifa mensual para moto clásica: ");
                    parqueadero.setTarifaDiaria(Parqueadero.TIPO_MOTO_CLASICA, tarifaDiariaMotoClasica);
                    parqueadero.setTarifaMensual(Parqueadero.TIPO_MOTO_CLASICA, tarifaMensualMotoClasica);

                    System.out.println("3. Moto Híbrida");
                    double tarifaDiariaMotoHibrida = leerDouble("Tarifa diaria para moto híbrida: ");
                    double tarifaMensualMotoHibrida = leerDouble("Tarifa mensual para moto híbrida: ");
                    parqueadero.setTarifaDiaria(Parqueadero.TIPO_MOTO_HIBRIDA, tarifaDiariaMotoHibrida);
                    parqueadero.setTarifaMensual(Parqueadero.TIPO_MOTO_HIBRIDA, tarifaMensualMotoHibrida);
                    break;

                case 3:
                    System.out.println("Estacionar vehículo");
                    System.out.println("Ingrese la placa del vehículo (formato ABC123): ");
                    String placa = scanner.next();
                    System.out.println("Ingrese el modelo del vehículo: ");
                    String modelo = scanner.next();
                    System.out.println("Ingrese el nombre del propietario del vehículo: ");
                    String propietario = scanner.next();
                    System.out.println("Ingrese el tipo del vehículo (1: Carro, 2: Moto Clásica, 3: Moto Híbrida): ");
                    int tipo = leerEntero("", 1, 3);

                    Vehiculo vehiculo;
                    if (tipo == Parqueadero.TIPO_CARRO) {
                        vehiculo = new Carro(placa, modelo, propietario);
                    } else if (tipo == Parqueadero.TIPO_MOTO_CLASICA) {
                        System.out.println("Ingrese la velocidad máxima del vehículo: ");
                        int velocidadMaxima = scanner.nextInt();
                        scanner.nextLine();
                        vehiculo = new Moto(placa, modelo, propietario, velocidadMaxima);
                    } else if (tipo == Parqueadero.TIPO_MOTO_HIBRIDA) {
                        System.out.println("Ingrese la velocidad máxima del vehículo: ");
                        int velocidadMaxima = scanner.nextInt();
                        scanner.nextLine();
                        vehiculo = new MotoHibrida(placa, modelo, propietario, velocidadMaxima);
                    } else {
                        System.out.println("Tipo de vehículo invalido");
                        continue;
                    }

                    System.out.println("Ingrese la fila y columna del puesto (fila columna): ");
                    int fila = leerEntero("Fila: ", 1, parqueadero.getFilas()) - 1;
                    int columna = leerEntero("Columna: ", 1, parqueadero.getColumnas()) - 1;

                    if (!parqueadero.puestoDisponible(fila, columna)) {
                        System.out.println("El puesto está ocupado.");
                        break;
                    }

                    if (parqueadero.estacionarVehiculo(vehiculo, fila, columna)) {
                        System.out.println("Vehículo estacionado correctamente.");
                    } else {
                        System.out.println("No se pudo estacionar el vehículo. El puesto se encuentra ocupado.");
                    }
                    break;

                case 4:
                    System.out.println("Ingrese la fila del puesto a desocupar: ");
                    fila = leerEntero("", 1, parqueadero.getFilas()) - 1;
                    System.out.println("Ingrese la columna del puesto a desocupar: ");
                    columna = leerEntero("", 1, parqueadero.getColumnas()) - 1;

                    Vehiculo vehiculoDesocupado = parqueadero.desocuparPuesto(fila, columna);
                    if (vehiculoDesocupado != null) {
                        System.out.println("Se ha desocupado el puesto de manera correcta.");
                    } else {
                        System.out.println("El puesto se encuentra vacío.");
                    }
                    break;

                case 5:
                    System.out.println("Ingrese la fila del puesto para identificar al propietario: ");
                    fila = leerEntero("", 1, parqueadero.getFilas()) - 1;
                    System.out.println("Ingrese la columna del puesto para identificar al propietario: ");
                    columna = leerEntero("", 1, parqueadero.getColumnas()) - 1;

                    String propietarioIdentificado = parqueadero.identificarPropietario(fila, columna);
                    if (propietarioIdentificado != null) {
                        System.out.println("El propietario del vehículo en ese puesto es: " + propietarioIdentificado);
                    } else {
                        System.out.println("El puesto se encuentra vacío.");
                    }
                    break;

                case 6:
                    Map<Integer, Double> reporteDiario = parqueadero.generarReporteDiario();
                    System.out.println("Reporte diario: ");
                    for (Map.Entry<Integer, Double> entry : reporteDiario.entrySet()) {
                        int tipoVehiculo = entry.getKey();
                        double costo = entry.getValue();
                        System.out.println("Tipo de vehículo: " + tipoVehiculo + ", Costo: $" + costo);
                    }
                    break;

                case 7:
                    Map<Integer, Double> reporteMensual = parqueadero.generarReporteMensual();
                    System.out.println("Reporte mensual: ");
                    for (Map.Entry<Integer, Double> entry : reporteMensual.entrySet()) {
                        int tipoVehiculo = entry.getKey();
                        double costoPorHora = parqueadero.getTarifas().getOrDefault(tipoVehiculo, 0.0);
                        double costoPorDia = parqueadero.getTarifasDiarias().getOrDefault(tipoVehiculo, 0.0);
                        double costoMensual = parqueadero.getTarifasMensuales().getOrDefault(tipoVehiculo, 0.0);
        
                        double total = entry.getValue();
                        total +=costoPorHora+costoPorDia+costoMensual;
                        

                        System.out.println("Tipo de vehículo: " + tipoVehiculo +  ", Costo total: $" + total);
                    }
                    break;

                case 8:
                    System.out.println("Estado del parqueadero: ");
                    for (int i = 0; i < parqueadero.getFilas(); i++) {
                        for (int j = 0; j < parqueadero.getColumnas(); j++) {
                            System.out.print(parqueadero.puestoDisponible(i, j) ? "L " : "O ");
                        }
                        System.out.println();
                    }
                    break;

                case 9:
                    salir = true;
                    break;

                default:
                    System.out.println("Opción invalida. Por favor, seleccione una opción del 1 al 9.");
            }
        }
    }

    public static int leerEntero(String mensaje) {
        System.out.println(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.println("Error: Debe ingresar un número entero.");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }

    public static int leerEntero(String mensaje, int min, int max) {
        int valor;
        do {
            valor = leerEntero(mensaje);
            if (valor < min || valor > max) {
                System.out.println("Error: Debe ingresar un número entre " + min + " y " + max + ".");
            }
        } while (valor < min || valor > max);
        return valor;
    }

    public static double leerDouble(String mensaje) {
        System.out.println(mensaje);
        while (!scanner.hasNextDouble()) {
            System.out.println("Error: Debe ingresar un número decimal.");
            scanner.next();
        }
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return valor;
    }
}


