package fpcore25_26.ejercicios_hilos.botelleros;

public class BotellaConThread extends Thread {

	private char caracter;
	private int capacidadMaxima;
	private int cantidad;
	private static long milis;

	{
		milis = 300;
	}

	public BotellaConThread(char caracter, int capacidadMaxima) {
		this.caracter = caracter != 0 ? caracter : '*';
		this.capacidadMaxima = capacidadMaxima < 1 ? 1 : capacidadMaxima;
		cantidad = this.capacidadMaxima;
	}

	private void vaciar() {

		while (cantidad > 0) {
			cantidad--;
			System.out.print(caracter);
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				System.out.printf("ERROR: %s %n", e.getMessage());
			}
		}
	}

	@Override
	public void run() {
		vaciar();
	}

	@Override
	public String toString() {
		return String.format("%s: %c [%d de %d]", getName(), caracter, cantidad, capacidadMaxima);
	}

	public static void main(String[] args) {

		BotellaConThread b1 = new BotellaConThread('-', 10);
		BotellaConThread b2 = new BotellaConThread('·', 5);
		BotellaConThread b3 = new BotellaConThread((char) 0, 0);

		System.out.println("Estado inicial:");
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);

		System.out.printf("%n%n");
		b1.start();
		b2.start();
		b3.start();

		/*
		 * join() te permite esperar a que los hilos terminen antes de continuar con la
		 * ejecución del hilo que lo llama (por ejemplo, main).
		 */
		try {
			b1.join();
			b2.join();
			b3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("\n\nEstado final:");
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);

	}

}
