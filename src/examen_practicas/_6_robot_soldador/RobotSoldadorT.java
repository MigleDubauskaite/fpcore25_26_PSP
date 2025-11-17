package examen_practicas._6_robot_soldador;

public class RobotSoldadorT extends Thread {

	private String nombre;
	private boolean soldando;
	private int ciclos;
	private static long milis = 300;

	public RobotSoldadorT(String nombre, int ciclos) {
		this.nombre = nombre == null ? "ROBOT-1" : nombre;
		this.ciclos = ciclos == 0 ? 1 : ciclos;
		soldando = false;
	}

	public void iniciarSoldadura() {

		if (!soldando && ciclos > 0) {

			soldando = true;

			int totalCiclos = ciclos;
			int soldadurasHechas = 0;

			System.out.printf("Robot %s empieza a soldar. %n", nombre);

			while (ciclos > 0) {

				ciclos--;
				soldadurasHechas = totalCiclos - ciclos;
				int soldadurasRestantes = totalCiclos - soldadurasHechas;

				System.out.printf("Robot %s ha soldado %d pieza%s... ciclos restantes: %d %n", nombre, soldadurasHechas,
						soldadurasHechas == 1 ? "" : "s", soldadurasRestantes);
				
				try {
					Thread.sleep(milis);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			System.out.printf("Robot %s deja de soldar. Hasta luego!!%n%n", nombre);

		}

	}
	
	@Override
	public void run() {
		iniciarSoldadura();
	}

	public static void main(String[] args) {

		RobotSoldadorT r1 = new RobotSoldadorT("Robot1", 5);
		RobotSoldadorT r2 = new RobotSoldadorT("Robot-F", 0);
		RobotSoldadorT r3 = new RobotSoldadorT("Robotito", 8);

		r1.start();
		r2.start();
		r3.start();

	}

}
