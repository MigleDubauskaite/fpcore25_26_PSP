package examen_practicas._3_cintas_transportadoras;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CintaRunnable implements Runnable {

	private int id;
	private static int nextID = 1;
	private int ciclos;
	private double metrosPorCiclo;
	private static long milis = 300;

	public CintaRunnable(int ciclos, double metrosPorCiclo) {
		id = nextID++;
		this.ciclos = ciclos > 0 ? ciclos : 1;
		this.metrosPorCiclo = metrosPorCiclo > 0 ? metrosPorCiclo : 0.5;
	}

	public void mover() {

		System.out.printf("Empezando la transportación de paquetes.%n");

		int ciclosTotales = ciclos;
		double metrosHechos = 0;

		while (ciclos > 0) {

			metrosHechos += metrosPorCiclo;
			double metrosTotales = metrosPorCiclo * ciclosTotales;

			double metrosRestantes = metrosTotales - metrosHechos;

			System.out.printf("[%d] Ciclo %d/%d → Hechos: %.2f m | Restan: %.2f m %n", id, ciclos, ciclosTotales,
					metrosHechos, metrosRestantes);

			ciclos--;

			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("[%d] Ya no quedan metros... %n", id);
		System.out.printf("[%d] El proceso ha finalizado.%n%n", id);

	}

	@Override
	public void run() {
		mover();
	}

	public static void main(String[] args) {

		CintaRunnable c = new CintaRunnable(2, 4);
		CintaRunnable c2 = new CintaRunnable(4, 16);

		Thread t1 = new Thread(c);
		Thread t2 = new Thread(c2);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n\nEXECUTOR SERVICE");
		
		ExecutorService executors = Executors.newFixedThreadPool(2);
		
		executors.execute(new CintaRunnable(5, 8));
		executors.execute(new CintaRunnable(10, 25));
		executors.shutdown();
		
	}

}
