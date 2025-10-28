package fpcore25_26.ejercicios_hilos.lanzador.adicionales;

public class Robot implements Runnable {

	private String nombre;
	private long milis;

	public Robot(String nombre, long milis) {
		this.nombre = nombre;
		this.milis = milis;
	}

	@Override
	public String toString() {
		return "Robot [nombre=" + nombre + ", milis=" + milis + "]";
	}

	@Override
	public void run() {
		System.out.printf("%s comienza la fabricación de piezas %n", nombre);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.printf("%s pasa al montaje %n", nombre);
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.printf("%s inicia pruebas finales... %n", nombre);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.printf("%s ha sido ensamblado con éxito ✅ %n", nombre);

	}

}
