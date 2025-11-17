package examen_practicas._3_cintas_transportadoras;

public class CintaTransportadora {

	private int id;
	private static int nextID = 1;
	private int ciclos;
	private double metrosPorCiclo;
	private static long milis = 300;

	public CintaTransportadora(int ciclos, double metrosPorCiclo) {
		id = nextID++;
		this.ciclos = ciclos > 0 ? ciclos : 1;
		this.metrosPorCiclo = metrosPorCiclo > 0 ? metrosPorCiclo : 0.5;
	}

	public void mover() {

		System.out.printf("[%d] Empezando la transportación de paquetes.%n", id);

		int ciclosTotales = ciclos;
		double metrosHechos = 0;
		double metrosTotales = metrosPorCiclo * ciclosTotales;

		while (ciclos > 0) {

			metrosHechos += metrosPorCiclo;

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

	public static void main(String[] args) {

		CintaTransportadora c = new CintaTransportadora(2, 4);
		c.mover();
		CintaTransportadora c2 = new CintaTransportadora(5, 10);
		c2.mover();

	}

}
