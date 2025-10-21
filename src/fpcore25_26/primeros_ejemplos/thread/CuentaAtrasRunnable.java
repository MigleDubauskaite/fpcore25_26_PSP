package fpcore25_26.primeros_ejemplos.thread;

public class CuentaAtrasRunnable implements Runnable {

	private String nombre;
	private int inicio;

	public CuentaAtrasRunnable(String nombre, int inicio) {
		this.nombre = nombre;
		this.inicio = inicio;
	}

	@Override
	public void run() {
		for (int i = inicio; i >= 0; i--) {
			System.out.printf("%s::%d %n ", nombre, i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}



}
