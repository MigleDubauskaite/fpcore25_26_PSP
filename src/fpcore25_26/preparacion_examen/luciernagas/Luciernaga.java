package fpcore25_26.preparacion_examen.luciernagas;

public class Luciernaga {

	private String nombre;
	private boolean encendida;
	private int energia;
	private static int milis = 400;

	public Luciernaga(String nombre, int energia) {
		this.nombre = nombre;
		this.energia = energia < 1 ? 1 : energia > 50 ? 50 : energia;
		encendida = false;
	}

	public void setEncendida(boolean encendida) {
		this.encendida = encendida;
	}

	private void reducirEnergia() {
		while (energia > 0) {
			System.out.println("Energia de " + nombre + ": " + energia--);
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		System.out.printf("⭐⭐⭐⭐⭐⭐Luciernaga %s ya no tiene energía. Adios! ⭐⭐⭐⭐⭐⭐ \n%n", nombre);
		encendida = false;
	}

	private void enciende() {

		if (energia >= 5 && !encendida) {
			System.out.printf("Luciernaga %s tiene energia y no estaba encendida:%n", nombre);
			encendida = true;
			reducirEnergia();
		}

		else if (encendida && energia >= 5) {
			System.out.printf("Luciernaga %s tiene energia y ya estaba encendida:%n", nombre);
			reducirEnergia();
		}

		else
			System.out.printf("%nLuciernaga %s no tiene energía / no está encendida...\n%n", nombre);
	}

	@Override
	public String toString() {
		return String.format("%s tiene %d de energía (%b)", nombre, energia, encendida);
	}

	public static void main(String[] args) {

		Luciernaga l = new Luciernaga("L1", 5);
		Luciernaga l2 = new Luciernaga("L2", 6);
		l2.setEncendida(true);
		Luciernaga l3 = new Luciernaga("L3", 7);

		System.out.println(l);
		System.out.println(l2);
		System.out.println(l3);
		System.out.println();

		l.enciende();

		l2.enciende();
		l2.enciende();

		l3.enciende();

		System.out.println();
		System.out.println("Estado después de ser encendidas");
		System.out.println();
		System.out.println(l);
		System.out.println(l2);
		System.out.println(l3);

	}

}
