package fpcore25_26.ejercicios_hilos.botelleros;

public class Botella extends Thread {

	private String nombre;
	private char caracter;
	private int cantidad;
	private static long milis = 300;

	public Botella(String nombre, char caracter, int cantidad) {
		this.nombre = nombre;
		this.caracter = caracter;
		this.cantidad = cantidad;
	}

	public void vaciar() {

		System.out.printf("Mi botella %s: ", nombre);
		for (int i = 0; i <= cantidad; i++) {
			System.out.print(caracter);
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {

		Botella b1 = new Botella("Botella 1", '*', 10);
		Botella b2 = new Botella("Botella 2", '·', 5);
		Botella b3 = new Botella("Botella 3", '⁜', 5);
		b1.vaciar();
		b2.vaciar();
		b3.vaciar();

	}

}
