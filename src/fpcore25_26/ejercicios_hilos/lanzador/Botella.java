package fpcore25_26.ejercicios_hilos.lanzador;

public class Botella {

	private String nombre;
	private int cantidad;
	private char caracter;
	private static long milis = 300;

	public Botella(String nombre, int cantidad, char caracter) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.caracter = caracter;
	}

	public void vaciar() {

		while (cantidad > 0) {
			System.out.print(caracter);
			cantidad--;
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public String toString() {
		return "LanzadorVaciadoBotella [nombre=" + nombre + ", cantidad=" + cantidad + ", caracter=" + caracter + "]";
	}

}
