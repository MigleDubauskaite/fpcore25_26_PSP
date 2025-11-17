package examen_practicas._4_arqueros_torneo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ArqueroRunnable implements Runnable {

	private int id;
	private static int nextID = 1;
	private String nombre;
	private int flechas;
	private double distanciaObjetivo;
	private static long milis = 300;

	public ArqueroRunnable(String nombre, int flechas, double distanciaObjetivo) {
		this.nombre = nombre;
		this.flechas = flechas;
		this.distanciaObjetivo = distanciaObjetivo;
		id = nextID++;
	}

	public void disparar() {

		System.out.printf("[%d] Arquero/a %s empieza disparar %d flechas a %.2f metros%n", id, nombre, flechas,
				distanciaObjetivo);

		for (int i = 1; i <= flechas; i++) {
			System.out.printf("[%d] Arquero/a %s dispara flecha %d/%d%n", id, nombre, i, flechas);
			
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.printf("[%d] Arquero/a %s ha terminado su turno%n%n", id, nombre);
	}

	@Override
	public void run() {
		disparar();
	}

	public static void main(String[] args) {

		ArqueroRunnable a = new ArqueroRunnable("Sofía", 5, 10);
		Thread t = new Thread(a);
		t.start();
		
		ArqueroRunnable a1 = new ArqueroRunnable("Lucas", 5, 10);
		Thread t2 = new Thread(a1);
		t2.start();
		
		try {
			t.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("\nEXECUTOR SERVICE");
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		executor.execute(new ArqueroRunnable("Amelia", 6, 100));
		executor.execute(new ArqueroRunnable("Amanda", 16, 50));
		executor.execute(new ArqueroRunnable("Natalia", 8, 120));
		
		executor.shutdown();
		

	}

}
