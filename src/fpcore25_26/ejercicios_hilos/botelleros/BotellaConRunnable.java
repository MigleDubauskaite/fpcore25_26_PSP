package fpcore25_26.ejercicios_hilos.botelleros;

public class BotellaConRunnable implements Runnable {

	private char caracter;
	private int capacidadMaxima;
	private int cantidad;
	private static long milis;

	{
		milis = 300;
	}

	public BotellaConRunnable(char caracter, int capacidadMaxima) {
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
		return String.format("%c [%d de %d]", caracter, cantidad, capacidadMaxima);
	}

	public static void main(String[] args) {

		BotellaConRunnable b1 = new BotellaConRunnable('-', 10);
		BotellaConRunnable b2 = new BotellaConRunnable('·', 5);
		BotellaConRunnable b3 = new BotellaConRunnable((char) 0, 0);

		System.out.println("Estado inicial:");
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);

		System.out.println();

		Thread t1 = new Thread(b1);
		Thread t2 = new Thread(b2);
		Thread t3 = new Thread(b3);

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

		System.out.println("\n\nEstado final:");
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
	}

}
