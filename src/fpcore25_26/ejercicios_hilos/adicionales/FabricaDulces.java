package fpcore25_26.ejercicios_hilos.adicionales;

import java.util.random.RandomGenerator;

public class FabricaDulces implements Runnable {

	private String nombre;
	private String emoji;
	private int stock;
	private int minimo;

	private static final RandomGenerator RANDOM = RandomGenerator.getDefault();

	public FabricaDulces(String nombre, String emoji, int stock, int minimo) {
		this.nombre = nombre;
		this.emoji = emoji;
		this.stock = stock;
		this.minimo = minimo;
	}

	private boolean intentandoVender(int cantidad) {
		if (minimo > stock || cantidad > stock) {
			System.out.printf("[%s] No hay suficiente stock. Esperando producción...%n", nombre);
			return false;
		}
		return true;
	}

	private void hacerDulces(int cantidad) {
		for (int i = 0; i < cantidad; i++) {
			
			stock++;
			System.out.printf("[%s] +1 %s (Stock actual: %d)%n", nombre, emoji, stock);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("[%s] Terminó de producir. Stock: %d%n", nombre, stock);
		System.out.println("------------------------------------");
	}

	private void venderDulces(int cantidad) {
		for (int i = 0; i < cantidad; i++) {
			
			if (stock <= 0) {
				System.out.printf("[%s] No queda stock para seguir vendiendo.%n", nombre);
				break;
			}
			
			stock--;
			System.out.printf("[%s] -1 %s (Stock restante: %d)%n", nombre, emoji, stock);
			System.out.print(emoji);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("[%s] 🏁 Venta terminada. Stock: %d%n", nombre, stock);
		System.out.println("------------------------------------");

	}

	@Override
	public void run() {

		for (int i = 0; i < 2; i++) {

			int cantidadVenta = RANDOM.nextInt(1, 5);
			int cantidadProduccion = RANDOM.nextInt(1, 4);

			if (!intentandoVender(cantidadVenta)) {
				hacerDulces(cantidadProduccion);
			}

			if (!intentandoVender(cantidadVenta)) {
				hacerDulces(cantidadProduccion);
			}
			venderDulces(cantidadProduccion);

			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String toString() {
		return "FabricaDulces [nombre=" + nombre + ", emoji=" + emoji + ", stock=" + stock + ", minimo=" + minimo + "]";
	}

	public static void main(String[] args) {

		FabricaDulces chocolate = new FabricaDulces("Chocolate", "🍫", 8, 3);
		FabricaDulces gominolas = new FabricaDulces("Gominolas", "🍬", 5, 2);
		FabricaDulces helados = new FabricaDulces("Helado", "🍧", 10, 4);

		System.out.println("\n🍭 Estado inicial de las fábricas:");
		System.out.println(chocolate);
		System.out.println(gominolas);
		System.out.println(helados);
		System.out.println("------------------------------------");

		Thread t1 = new Thread(chocolate);
		Thread t2 = new Thread(gominolas);
		Thread t3 = new Thread(helados);

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

		System.out.println("\n🏁 Estado final de las fábricas:");
		System.out.println(chocolate);
		System.out.println(gominolas);
		System.out.println(helados);

	}

}
