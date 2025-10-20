package fpcore25_26.primeros_ejemplos.thread;

public class CuentaAtras extends Thread {

	private String nombre;
	private int inicio;

	public CuentaAtras(String nombre, int inicio) {
		this.nombre = nombre;
		this.inicio = inicio;
	}

	@Override
	public void run() {
		for (int i = inicio; i >= 0; i--) {
			System.out.printf("%s::%d %n", nombre, i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
