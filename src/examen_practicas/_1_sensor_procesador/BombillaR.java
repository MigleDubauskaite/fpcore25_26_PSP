package examen_practicas._1_sensor_procesador;

import java.util.ArrayList;
import java.util.List;

public class BombillaR implements Runnable {

	private String nombre;
	private int valor;
	private boolean encendida;
	private static int milis = 300;

	public BombillaR(String nombre, int valor) {
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

	public static void main(String[] args) throws InterruptedException {

		BombillaR b1 = new BombillaR("S1", 10);
		Thread t1 = new Thread(b1);

		List<Thread.State> estados = new ArrayList<>();
		Thread.State state;

		// Estado NEW
		state = t1.getState();
		estados.add(state);
		System.out.println("Inicial: " + state);

		// Estado RUNNABLE
		t1.start();
		state = t1.getState();
		estados.add(state);
		System.out.println("Después de start(): " + state);

		// Mientras está vivo
		while (t1.isAlive()) {
			state = t1.getState();
			estados.add(state);
			System.out.println("Durante ejecución: " + state);
			Thread.sleep(milis / 2);
		}

		// Estado TERMINATED
		state = t1.getState();
		estados.add(state);
		System.out.println("Final: " + state);

		System.out.println("\n\nTodos los estados por los que pasó el hilo:");
		estados.forEach(System.out::println);
		System.out.printf("Cantidad de estados almacenados: %d%n", estados.size());

	}
}
