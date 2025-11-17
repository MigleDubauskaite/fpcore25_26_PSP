package examen_practicas._6_robot_soldador;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RobotSoldadorR implements Runnable {

	private String nombre;
	private boolean soldando;
	private int ciclos;
	private static long milis = 300;

	public RobotSoldadorR(String nombre, int ciclos) {
		this.nombre = nombre == null ? "ROBOT-1" : nombre;
		this.ciclos = ciclos == 0 ? 1 : ciclos;
		soldando = false;
	}

	public void iniciarSoldadura() {

		if (!soldando && ciclos > 0) {

			soldando = true;

			int totalCiclos = ciclos;
			int soldadurasHechas = 0;

			System.out.printf("Robot %s empieza a soldar. %n", nombre);

			while (ciclos > 0) {

				ciclos--;
				soldadurasHechas = totalCiclos - ciclos;
				int soldadurasRestantes = totalCiclos - soldadurasHechas;

				System.out.printf("Robot %s ha soldado %d pieza%s... ciclos restantes: %d %n", nombre, soldadurasHechas,
						soldadurasHechas == 1 ? "" : "s", soldadurasRestantes);
				
				try {
					Thread.sleep(milis);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			System.out.printf("Robot %s deja de soldar. Hasta luego!!%n%n", nombre);

		}

	}
	
	@Override
	public void run() {
		iniciarSoldadura();
	}

	public static void main(String[] args) {

		RobotSoldadorR r1 = new RobotSoldadorR("Robot1", 5);
		RobotSoldadorR r2 = new RobotSoldadorR("Robot-F", 0);
		RobotSoldadorR r3 = new RobotSoldadorR("Robotito", 8);
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);

		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("\nEXECUTOR SERVICE");
		
		ExecutorService executor = Executors.newFixedThreadPool(1);
		
		executor.execute(new RobotSoldadorR("ROBOT-R", 10));
		executor.execute(new RobotSoldadorR("ROBOT-M", 4));
		executor.execute(new RobotSoldadorR("ROBOT-C", 6));
		executor.shutdown();
		
	}

}
