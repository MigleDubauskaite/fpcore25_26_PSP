package fpcore25_26.primeros_ejemplos.thread.ejercicios_adicionales;

public class Cajero extends Thread {

	private String nombre;
	private int tiempo;

	public Cajero(String nombre, int tiempo) {
		this.nombre = nombre;
		this.tiempo = tiempo;
	}

	@Override
	public void run() {

		for (int cliente = 1; cliente <= 5; cliente++) {
			System.out.printf("%s COMIENZA A atender al cliente %d %n", nombre, cliente);
			try {
				Thread.sleep(tiempo);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			System.out.printf("%s TERMINA DE atender al cliente %d %n", nombre, cliente);
		}
		System.out.printf("%s HA TERMINADO su trabajo. %n%n", nombre);

	}

	public static void main(String[] args) {

		Cajero c1 = new Cajero("Cajero 1", 100);
		Cajero c2 = new Cajero("Cajero 2", 200);
		Cajero c3 = new Cajero("Cajero 3", 120);

		// monohilo
		c1.run();
		c2.run();
		c3.run();

		// multihilo:
		System.out.println("\n\nPROBAMOS EL MULTIHILO \n");
		c1.start();
		c2.start();
		c3.start();

	}

}
