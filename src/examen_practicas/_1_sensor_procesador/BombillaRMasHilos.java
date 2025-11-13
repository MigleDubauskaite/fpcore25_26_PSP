package examen_practicas._1_sensor_procesador;

import java.util.ArrayList;
import java.util.List;

public class BombillaRMasHilos implements Runnable {

	private String nombre;
	private int valor;
	private boolean encendida;
	private static int milis = 300;

	public BombillaRMasHilos(String nombre, int valor) {
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
		BombillaR b2 = new BombillaR("S2", 13);
		BombillaR b3 = new BombillaR("S3", 20);

		Thread t1 = new Thread(b1);
		Thread t2 = new Thread(b2);
		Thread t3 = new Thread(b3);

		// Crear listas para almacenar los estados de cada hilo
		List<Thread.State> estadosT1 = new ArrayList<>();
		List<Thread.State> estadosT2 = new ArrayList<>();
		List<Thread.State> estadosT3 = new ArrayList<>();

		// Estado NEW
		estadosT1.add(t1.getState());
		estadosT2.add(t2.getState());
		estadosT3.add(t3.getState());

		System.out.println("Estados iniciales:");
		System.out.println("T1: " + t1.getState());
		System.out.println("T2: " + t2.getState());
		System.out.println("T3: " + t3.getState());
		System.out.println();

		t1.start();
		t2.start();
		t3.start();

		// Estado RUNNABLE
		estadosT1.add(t1.getState());
		estadosT2.add(t2.getState());
		estadosT3.add(t3.getState());

		// Mientras alguno de los hilos esté vivo
		while (t1.isAlive() || t2.isAlive() || t3.isAlive()) {
			estadosT1.add(t1.getState());
			estadosT2.add(t2.getState());
			estadosT3.add(t3.getState());
			Thread.sleep(milis / 3);
		}

		// Estado TERMINATED
		estadosT1.add(t1.getState());
		estadosT2.add(t2.getState());
		estadosT3.add(t3.getState());

		System.out.println("\nEstados finales:");
		System.out.println("T1: " + t1.getState());
		System.out.println("T2: " + t2.getState());
		System.out.println("T3: " + t3.getState());

		System.out.println("\nTodos los estados por los que pasaron los hilos:");
		System.out.println("T1:");
		estadosT1.forEach(System.out::println);
		System.out.println("T2:");
		estadosT2.forEach(System.out::println);
		System.out.println("T3:");
		estadosT3.forEach(System.out::println);

	}
}
