package fpcore25_26.ejercicios_hilos.adicionales;

import java.util.random.RandomGenerator;

public class Dulceria implements Runnable {

	private String nombre;
	private String tipo;
	private int stock;

	private final static RandomGenerator RANDOM = RandomGenerator.getDefault();

	public Dulceria(String nombre, String tipo, int stock) {
		this.nombre = nombre != null ? nombre : "Caramelo";
		this.tipo = tipo != null ? tipo : "🧁";
		this.stock = stock;
	}

	private void venderDulce(int cantidad) {

		if (cantidad > stock)
			cantidad = stock; // no vendemos más de lo que hay

		System.out.printf("[%s] 🛒 Empieza venta de %d %s%n", nombre, cantidad, tipo.repeat(cantidad));

		StringBuilder sb = new StringBuilder();
		/*
		 * Uso de StringBuilder para juntar todos los emojis en una sola impresión (más
		 * limpio y menos entrelazado entre hilos).
		 */

		for (int i = 0; i < cantidad; i++) {
			stock--;
			sb.append(tipo);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("[%s] Vendió: %s → Stock restante: %d%n", nombre, sb, stock);
		System.out.println("------------------------------------");
	}

	private void hacerDulce(int cantidad) {

		System.out.printf("[%s] 👩‍🍳 Empieza a hacer %d %s%n", nombre, cantidad, tipo.repeat(cantidad));
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < cantidad; i++) {
			stock++;
			sb.append(tipo);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("[%s] Hizo: %s → Stock actual: %d%n", nombre, sb, stock);
		System.out.println("------------------------------------");
	}

	@Override
	public void run() {

		for (int i = 0; i < 1; i++) {

			int cantidadVenta = RANDOM.nextInt(1, 5);
			venderDulce(cantidadVenta);

			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			int cantidadHacer = RANDOM.nextInt(1, 3);
			hacerDulce(cantidadHacer);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public String toString() {
		return String.format("Queda%s %d %s %s", stock == 1 ? "" : "n", stock, stock == 1 ? nombre : (nombre + "s"),
				tipo.repeat(stock));
	}

	public static void main(String[] args) {

		Dulceria d2 = new Dulceria("Gominolas", "🍬", 8);
		Dulceria d3 = new Dulceria("Chocolate", "🍫", 5);
		Dulceria d4 = new Dulceria("Helado", "🍧", 10);

		System.out.println("\nEstado inicial: ");
		System.out.println(d2);
		System.out.println(d3);
		System.out.println(d4);
		System.out.println("\n");

		Thread t1 = new Thread(d2);
		Thread t2 = new Thread(d3);
		Thread t3 = new Thread(d4);

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

		System.out.println("\n\nEstado final: ");
		System.out.println(d2);
		System.out.println(d3);
		System.out.println(d4);

	}

}
