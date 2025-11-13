package examen_practicas._1_sensor_procesador;

public class Bombilla {

	private String nombre;
	private int valor;
	private boolean encendida;
	private static final int milis = 300;

	public Bombilla(String nombre, int valor) {
		this.nombre = nombre != null ? nombre : "Sensor sin nombre";
		this.valor = valor < 10 ? 10 : valor > 100 ? 100 : valor;
		encendida = false;
	}

	public void encender() {

		if (!encendida && valor >= 10) {

			encendida = true;

			while (valor > 0) {
				System.out.printf("%s tiene %d%% %n", nombre, valor);
				valor--;
				try {
					Thread.sleep(milis);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			encendida = false;
			System.out.printf("%s no tiene %% (%d) %n", nombre, valor);
		}

	}

	public static void main(String[] args) {

		Bombilla s1 = new Bombilla("S1", 10);
		Bombilla s2 = new Bombilla("S2", 13);
		Bombilla s3 = new Bombilla("S3", 20);

		s1.encender();
		s2.encender();
		s3.encender();
	}

}
