package examen_practicas._6_robot_soldador;

public class RobotSoldador {

	private String nombre;
	private boolean soldando;
	private int ciclos;
	private static long milis = 300;

	public RobotSoldador(String nombre, int ciclos) {
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

	public static void main(String[] args) {

		RobotSoldador r1 = new RobotSoldador("Robot1", 5);
		RobotSoldador r2 = new RobotSoldador("Robot-F", 0);
		RobotSoldador r3 = new RobotSoldador("Robotito", 8);

		r1.iniciarSoldadura();
		r2.iniciarSoldadura();
		r3.iniciarSoldadura();

	}

}
