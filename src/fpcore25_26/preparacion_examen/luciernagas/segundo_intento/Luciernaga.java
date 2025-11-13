package fpcore25_26.preparacion_examen.luciernagas.segundo_intento;

public class Luciernaga {

	private String nombre;
	private boolean encendido;
	private int energia;
	private static long milis = 300;

	public Luciernaga(String nombre, boolean encendido, int energia) {
		this.nombre = nombre != null ? nombre : "Luciernaga Desconocida";
		this.encendido = encendido;
		this.energia = energia < 1 ? 1 : energia > 50 ? 50 : energia;
	}

	private void reducirEnergia() {

		while (energia > 0) {
			energia--;
			System.out.printf("%s tiene %d %% %n", nombre, energia);
		}

		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("%s ya no tiene energía...%n%n", nombre);
		encendido = false;
	}

	public void enciende() {

		if (!encendido && energia > 5) {
			encendido = true;
			reducirEnergia();
		}

		else if (encendido && energia > 5) {
			reducirEnergia();
		}

		else if (energia <= 5)
			System.out.printf("%s no puede encenderse... %n", nombre);

	}

	@Override
	public String toString() {
		return String.format("%s (%b) tiene %d %% de energía", nombre, encendido, energia);
	}

	public static void main(String[] args) {

		Luciernaga l1 = new Luciernaga("Luci", true, 8);
		Luciernaga l2 = new Luciernaga("Brilla", false, 6);
		Luciernaga l3 = new Luciernaga("Chispa", true, 9);

		l1.enciende();
		l2.enciende();
		l3.enciende();

	}

}
