package fpcore25_26.primeros_ejemplos.thread.ejercicios_adicionales;

public class Corredor extends Thread {

	private String nombre;
	private int velocidad;

	public Corredor(String nombre, int velocidad) {
		this.nombre = nombre;
		this.velocidad = velocidad;
	}

	@Override
	public void run() {
		for (int metros = 0; metros < 100; metros += 25) {
			System.out.printf("%s ha AVANZADO %d metros%n", nombre, metros);
			try {
				Thread.sleep(velocidad);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.printf("%s ha LLEGADO a la meta%n", nombre);
	}

	public static void main(String[] args) {

		Corredor c1 = new Corredor("Corredor 1", 400);
		Corredor c2 = new Corredor("Corredor 2", 500);
		Corredor c3 = new Corredor("Corredor 3", 800);

		c1.run();
		c2.run();
		c3.run();

		System.out.println("\n\n\nMULTIHILO \n");

		c1.start();
		c2.start();
		c3.start();
		System.out.printf("La carrera ha terminado%n%n");

	}

}
