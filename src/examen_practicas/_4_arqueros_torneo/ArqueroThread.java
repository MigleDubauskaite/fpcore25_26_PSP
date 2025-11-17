package examen_practicas._4_arqueros_torneo;

public class ArqueroThread extends Thread {

	private int id;
	private static int nextID = 1;
	private String nombre;
	private int flechas;
	private double distanciaObjetivo;
	private static long milis = 300;

	public ArqueroThread(String nombre, int flechas, double distanciaObjetivo) {
		this.nombre = nombre;
		this.flechas = flechas;
		this.distanciaObjetivo = distanciaObjetivo;
		id = nextID++;
	}

	public void disparar() {

		System.out.printf("[%d] Arquero/a %s empieza disparar %d flechas a %.2f metros%n", id, nombre, flechas,
				distanciaObjetivo);

		for (int i = 1; i <= flechas; i++) {
			System.out.printf("[%d] Arquero/a %s dispara flecha %d/%d%n", id, nombre, i, flechas);
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.printf("[%d] Arquero/a %s ha terminado su turno%n%n", id, nombre);
	}

	@Override
	public void run() {
		disparar();
	}

	public static void main(String[] args) {

		ArqueroThread a = new ArqueroThread("Sofía", 5, 10);
		a.start();
		
		ArqueroThread a1 = new ArqueroThread("Lucas", 5, 10);
		a1.start();

	}

}
