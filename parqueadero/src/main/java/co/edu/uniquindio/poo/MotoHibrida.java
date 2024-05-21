package co.edu.uniquindio.poo;

public class MotoHibrida extends Moto {
    /**
     * @param placa La placa de la moto.
     * @param modelo El modelo de la moto.
     * @param propietario Dueño de la moto.
     * @param velocidadMaxima La velocidad máxima de la moto.
     */
    public MotoHibrida(String placa, String modelo, String propietario, int velocidadMaxima) {
        super(placa, modelo, propietario, velocidadMaxima);
    }

    @Override
    public int getTipo() {
        return Parqueadero.TIPO_MOTO_HIBRIDA; // retorna el tipo de moto híbrida
    }
}

