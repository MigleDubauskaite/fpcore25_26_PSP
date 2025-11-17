package examen_practicas._3_cintas_transportadoras;

public class CintaThread extends Thread {

	private int id;
	private static int nextID = 1;
	private int ciclos;
	private double metrosPorCiclo;
	private static long milis = 300;

	public CintaThread(int ciclos, double metrosPorCiclo) {
		id = nextID++;
		this.ciclos = ciclos > 0 ? ciclos : 1;
		this.metrosPorCiclo = metrosPorCiclo > 0 ? metrosPorCiclo : 0.5;
	}

	public void mover() {

		System.out.printf("Empezando la transportación de paquetes.%n");

		int ciclosTotales = ciclos;
		double metrosHechos = 0;

		while (ciclos > 0) {

			metrosHechos += metrosPorCiclo;
			double metrosTotales = metrosPorCiclo * ciclosTotales;

			double metrosRestantes = metrosTotales - metrosHechos;

			System.out.printf("[%d] Ciclo %d/%d → Hechos: %.2f m | Restan: %.2f m %n", id, ciclos, ciclosTotales,
					metrosHechos, metrosRestantes);

			ciclos--;

			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("[%d] Ya no quedan metros... %n", id);
		System.out.printf("[%d] El proceso ha finalizado.%n%n", id);

	}

	@Override
	public void run() {
		mover();
	}

	public static void main(String[] args) {

		CintaThread c = new CintaThread(2, 4);
		CintaThread c2 = new CintaThread(6, 4);

		c.start();
		c2.start();
	}

}
