package fpcore25_26.ejercicios_hilos.adicionales;

import java.util.random.RandomGenerator;

public class FabricaRobots implements Runnable {

	private String nombre;
	private int stock;

	private final static RandomGenerator RANDOM = RandomGenerator.getDefault();

	public FabricaRobots(String nombre, int stock) {
		this.nombre = nombre != null ? nombre : "Sección";
		this.stock = stock < 1 ? 1 : stock;
	}

	private void fabricar(int cantidad) {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < cantidad; i++) {
			stock++;
			sb.append("➕");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("[%s] Fabricó %s → Stock actual: %d %n", nombre, sb, stock);
		System.out.println("------------------------------------");
	}

	private void probar(int cantidad) {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < cantidad; i++) {
			stock--;
			sb.append("➖");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.printf("[%s] Probó %s → Stock actual: %d %n", nombre, sb, stock);
		System.out.println("------------------------------------");
	}

	@Override
	public void run() {

		for (int i = 0; i < 2; i++) {

			int cantidadFabricar = RANDOM.nextInt(1, 5);
			fabricar(cantidadFabricar);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			int cantidadProbar = RANDOM.nextInt(1, 5);
			probar(cantidadProbar);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public String toString() {
		return String.format("Hay %d robot%s de %s", stock, stock > 1 ? "s" : "", nombre);
	}

	public static void main(String[] args) {

		FabricaRobots fr = new FabricaRobots("Pintura", 5);
		System.out.println(fr);
		fr.fabricar(2);
		System.out.println(fr);
		fr.probar(6);
		System.out.println(fr);

		System.out.println("\nPRUEBAS\n");

		System.out.println("\nEstado inicial\n");

		FabricaRobots fr1 = new FabricaRobots("Pintura", 5);
		FabricaRobots fr2 = new FabricaRobots("Ensamblaje", 8);
		FabricaRobots fr3 = new FabricaRobots("Pruebas", 6);
		FabricaRobots fr4 = new FabricaRobots("Empaque", 4);

		System.out.println(fr1);
		System.out.println(fr2);
		System.out.println(fr3);
		System.out.println(fr4);
		System.out.println();

		Thread t1 = new Thread(fr1);
		Thread t2 = new Thread(fr2);
		Thread t3 = new Thread(fr3);
		Thread t4 = new Thread(fr4);

		t1.start();
		t2.start();
		t3.start();
		t4.start();

		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("\nEstado final\n");
		System.out.println(fr1);
		System.out.println(fr2);
		System.out.println(fr3);
		System.out.println(fr4);

	}

}
