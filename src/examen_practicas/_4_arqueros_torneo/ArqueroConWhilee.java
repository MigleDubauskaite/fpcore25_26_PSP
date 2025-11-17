package examen_practicas._4_arqueros_torneo;

public class ArqueroConWhilee {

	private int id;
	private static int nextID = 1;
	private String nombre;
	private int flechas;
	private double distanciaObjetivo;
	private static long milis = 300;

	public ArqueroConWhilee(String nombre, int flechas, double distanciaObjetivo) {
		this.nombre = nombre;
		this.flechas = flechas;
		this.distanciaObjetivo = distanciaObjetivo;
		id = nextID++;
	}

	public void disparar() {

		System.out.printf("[%d] Arquero/a %s empieza disparar %d flechas a %.2f metros%n", id, nombre, flechas,
				distanciaObjetivo);

		int totalFlechas = flechas;
		int flechasLanzadas = 0;

		while (flechas > 0) {

			flechasLanzadas = --flechas;
			int flechasRestantes = totalFlechas - flechasLanzadas;

			System.out.printf("[%d] Arquero/a %s dispara flecha %d/%d%n", id, nombre, flechasRestantes, totalFlechas);
			
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.printf("[%d] Arquero/a %s ha terminado su turno%n%n", id, nombre);
	}

	public static void main(String[] args) {

		ArqueroConWhilee a = new ArqueroConWhilee("Sofía", 5, 10);
		a.disparar();

		ArqueroConWhilee a1 = new ArqueroConWhilee("Lucas", 5, 10);
		a1.disparar();

	}

}
