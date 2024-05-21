package parqueadero2

public abstract class Vehiculo {
    protected String placa; // Placa del vehículo
    protected String modelo; // Modelo del vehículo
    protected String propietario;// Nombre del propietario del vehículo

    /**
     * Constructor de la clase Vehiculo.
     * @param placa La placa del vehículo.
     * @param modelo El modelo del vehículo.
     * @param propietario El nombre del propietario del vehículo.
     */
    public Vehiculo (String placa, String modelo, String propietario) {
        this.placa = placa;
        this.modelo = modelo;
        this.propietario= propietario;
    }

     /**
     * Método para obtener la placa del vehículo.
     * @return 
     */
    public String getPlaca(){
        return placa;
    }

    /**
     * Método para obtener el modelo del vehículo.
     * @return 
     */
    public String getModelo(){
        return modelo;
    }

    /**
     * Método para obtener el nombre del propietario del vehículo.
     * @return 
     */
    public String getPropietario(){
        return propietario;
    }

    /**
     * Método abstracto para obtener el tipo de vehículo.
     * @return 
     */
    protected abstract int getTipo();
}


