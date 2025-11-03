package fpcore25_26.preparacion_examen.luciernagas;

public class LuciernagaR implements Runnable {

	private String nombre;
	private boolean encendida;
	private int energia;
	private static int milis = 400;

	public LuciernagaR(String nombre, int energia) {
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
	public void run() {
		enciende();
	}

	@Override
	public String toString() {
		return String.format("%s tiene %d  de energía (%b)", nombre, energia, encendida);
	}

	public static void main(String[] args) {

		LuciernagaR lr1 = new LuciernagaR("LR1", 5);
		LuciernagaR lr2 = new LuciernagaR("LR2", 6);
		LuciernagaR lr3 = new LuciernagaR("LR3", 7);

		Thread t1 = new Thread(lr1);
		Thread t2 = new Thread(lr2);
		Thread t3 = new Thread(lr3);

		t1.start();
		t2.start();
		t3.start();

		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(lr1);
		System.out.println(lr2);
		System.out.println(lr3);

	}

}
