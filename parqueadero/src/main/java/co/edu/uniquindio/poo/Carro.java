package co.edu.uniquindio.poo;

public class Carro extends Vehiculo {

    /**
     * Constructor de la clase Carro.
     * @param placa La placa del carro.
     * @param modelo El modelo del carro.
     * @param propietario El propietario del carro.
     */
    public Carro(String placa, String modelo, String propietario) {
        super(placa, modelo, propietario);
    }

    /**
     * Método que devuelve el tipo de vehículo, en este caso, tipo carro.
     * @return El tipo de vehículo.
     */
    @Override
    public int getTipo() {
        return Parqueadero.TIPO_CARRO;
    }
    
}