package examen_practicas._5_carrera_drones;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DroneR implements Runnable{

	private int id;
	private static int nextID = 1;
	private String modelo;
	private double metrosVuelo;
	private static long velocidad = 300;

	public DroneR(String modelo, double metrosVuelo) {
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

		DroneR d = new DroneR("DRONE-F", 55);
		Thread t = new Thread(d);
		t.start();
		
		DroneR d2 = new DroneR(null, 0);
		Thread t2 = new Thread(d2);
		t2.start();
		
		try {
			t.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("\nEXECUTOR SERVICE");
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new DroneR("DRONE-M", 100));
		executor.execute(new DroneR("DRONE-U", 30));
		executor.shutdown();

	}

}
