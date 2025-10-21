package fpcore25_26.primeros_ejemplos.thread.ejercicios_adicionales;

public class Robot implements Runnable {

	/*
	 * Usar Runnable es más flexible y profesional porque separa: - Qué se hace
	 * (Runnable) - Cómo se ejecuta (Thread)
	 */

	private String nombre;
	private int tiempo;

	public Robot(String nombre, int tiempo) {
		this.nombre = nombre;
		this.tiempo = tiempo;
	}

	@Override
	public void run() {
		System.out.printf("El Robot %s COMIENZA su ensamblaje%n", nombre);
		try {
			/*
			 * Thread.sleep(long millis) es un método estático de la clase Thread que hace
			 * que el hilo actual se detenga temporalmente durante un tiempo específico (en
			 * milisegundos).
			 */
			Thread.sleep(tiempo);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.printf("El Robot %s ha TERMINADO su ensamblaje%n", nombre);
	}

	public static void main(String[] args) {

		Robot r1 = new Robot("A", 1000);
		Robot r2 = new Robot("B", 1500);
		Robot r3 = new Robot("C", 700);

		new Thread(r1).start();
		new Thread(r2).start();
		new Thread(r3).start();

	}

}
