package fpcore25_26.ejercicios_hilos.botelleros.repiticiones;

public class Botella1 {

	private String nombre;
	private char caracter;
	private int cantidad;
	private static long milis = 400;

	public Botella1(String nombre, char caracter, int cantidad) {
		this.nombre = nombre;
		this.caracter = caracter;
		this.cantidad = cantidad;
	}

	private void vaciar() {
		while (cantidad > 0) {
			System.out.print(caracter);
			cantidad--;
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	}

	@Override
	public String toString() {
		return "Botella1 [nombre=" + nombre + ", caracter=" + caracter + ", cantidad=" + cantidad + "]";
	}

	public static void main(String[] args) {
		Botella1 b1 = new Botella1("B1", '*', 5);
		System.out.println(b1);
		b1.vaciar();
		System.out.println(b1);
	}

}
