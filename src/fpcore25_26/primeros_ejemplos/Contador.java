package fpcore25_26.primeros_ejemplos;

import java.time.Duration;

public class Contador extends Thread {

	private int valorFinal;
	private String nombre;
	private static int milis = 300;

	public Contador(int valorFinal, String nombre) {
		this.valorFinal = valorFinal;
		this.nombre = nombre;
	}

	@Override
	public void run() {
		for (int i = 0; i < valorFinal; i++) {
			System.out.printf("%s: %d %n", nombre, i);
			try {
				Thread.sleep(Duration.ofMillis(milis));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Contador c1 = new Contador(10, "C1");
		Contador c2 = new Contador(3, "C2");
		
		c1.start();
		c2.start();
	}

}
