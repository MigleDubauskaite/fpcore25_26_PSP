package examen_practicas._5_carrera_drones;

public class DroneT extends Thread {

	private int id;
	private static int nextID = 1;
	private String modelo;
	private double metrosVuelo;
	private static long velocidad = 300;

	public DroneT(String modelo, double metrosVuelo) {
		id = nextID++;
		this.modelo = modelo != null ? modelo : "DRON-DESC";
		this.metrosVuelo = metrosVuelo > 10 ? metrosVuelo : 10;
	}

	public void volar() {

		System.out.printf("[%d] El dron %s empieza su trayecto de %.2f metros.%n", id, modelo, metrosVuelo);

		double recorridoMetros = 0;

		while (recorridoMetros < metrosVuelo) {

			recorridoMetros += 10;

			if (recorridoMetros > metrosVuelo)
				recorridoMetros = metrosVuelo;

			double metrosRestantes = metrosVuelo - recorridoMetros;

			System.out.printf("[%d] El dron %s ha avanzado %.2f m y le quedan %.2f metros.%n", id, modelo,
					recorridoMetros, metrosRestantes);

			try {
				Thread.sleep(velocidad);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.printf("[%d] El dron %s terminó su trayecto de %.2f metros.%n%n", id, modelo, metrosVuelo);
	}
	

	@Override
	public void run() {
		volar();
	}

	public static void main(String[] args) {

		DroneT d = new DroneT("DRONE-F", 55);
		d.start();
		DroneT d2 = new DroneT(null, 0);
		d2.start();

	}

}
