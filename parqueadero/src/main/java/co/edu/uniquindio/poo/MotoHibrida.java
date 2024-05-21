package co.edu.uniquindio.poo;
public class MotoHibrida extends Vehiculo {
    private int velocidadMaxima; // La velocidad máxima que alcanza la moto.

    /**
     * @param placa La placa de la moto.
     * @param modelo El modelo de la moto.
     * @param propietario Dueño de la moto.
     * @param velocidadMaxima La velocidad máxima de la moto.
     */
    public MotoHibrida(String placa, String modelo, String propietario, int velocidadMaxima) {
        super(placa, modelo, propietario);
        this.velocidadMaxima = velocidadMaxima;
    }

    /**
     * Método para obtener el tipo de vehículo (motohibrida)
     * @return 
     */
    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    @Override
    public int getTipo() {
        return Parqueadero.TIPO_MOTO_HIBRIDA; // retorna el tipo de moto
    }

}