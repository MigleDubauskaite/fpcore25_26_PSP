package examen_practicas._1_sensor_procesador;

public class BombillaT extends Thread {

	private String nombre;
	private int valor;
	private boolean encendida;
	private static int milis = 300;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BombillaT(String nombre, int valor) {
		this.nombre = nombre != null ? nombre : "Sensor sin nombre";
		this.valor = valor < 10 ? 10 : valor > 100 ? 100 : valor;
		encendida = false;
	}

	public void encender() {

		if (!encendida && valor >= 10) {
			encendida = true;

			while (valor > 0) {
				System.out.printf("%s tiene %d %% %n", nombre, valor);
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

	@Override
	public void run() {
		encender();
	}

	public static void main(String[] args) {

		BombillaT s1 = new BombillaT("S1", 10);
		BombillaT s2 = new BombillaT("S2", 13);
		BombillaT s3 = new BombillaT("S3", 20);

		System.out.printf("Estado: %s %n", s1.getState());
		System.out.printf("Estado: %s %n", s2.getState());
		System.out.printf("Estado: %s %n", s3.getState());

		s1.start();
		s2.start();
		s3.start();

		System.out.printf("Estado: %s %n", s1.getState());
		System.out.printf("Estado: %s %n", s2.getState());
		System.out.printf("Estado: %s %n", s3.getState());

		try {
			s1.join();
			s2.join();
			s3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("\nHilos finalizados.");
		System.out.printf("Estado: %s %n", s1.getState());
		System.out.printf("Estado: %s %n", s2.getState());
		System.out.printf("Estado: %s %n", s3.getState());

	}

}
