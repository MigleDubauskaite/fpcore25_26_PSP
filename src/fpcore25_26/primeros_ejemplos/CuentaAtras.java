package fpcore25_26.primeros_ejemplos;

public class CuentaAtras extends Thread {

	private int valorInicial;
	private String nombre;
	private static int milis = 300;

	public CuentaAtras(int valorInicial, String nombre) {
		this.valorInicial = valorInicial; this.nombre = nombre;
	}

	@Override
	public void run() {arranca();}

	public void arranca() {
		for (int i = valorInicial; i >= 0; i--) {
			System.out.printf("%s: %d%n", nombre, i);
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void main(String[] args) {
		CuentaAtras c1 = new CuentaAtras(10, "C-1");
		CuentaAtras c2 = new CuentaAtras(5, "C-2");
		System.out.println("Programa empezando");
		c1.start();
		System.out.println("Programa empezado");
		c2.start();
		System.out.println("Programa acabado");

		// start() -> run() -> arranca() : para que enlaze con otro hilo y que siga

	}

}
