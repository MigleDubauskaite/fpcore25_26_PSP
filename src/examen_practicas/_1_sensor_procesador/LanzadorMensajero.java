package examen_practicas._1_sensor_procesador;

public class LanzadorMensajero extends Thread {

	private Mensajero mensajero;

	public LanzadorMensajero(Mensajero mensajero) {
		this.mensajero = mensajero;
	}

	@Override
	public void run() {
		mensajero.enviar();
	}

}
