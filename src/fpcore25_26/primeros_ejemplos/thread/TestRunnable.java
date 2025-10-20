package fpcore25_26.primeros_ejemplos.thread;

public class TestRunnable {

	public static void main(String[] args) {

		CuentaAtras ca1 = new CuentaAtras("C1", 10);
		CuentaAtras ca2 = new CuentaAtras("C2", 5);

		ca1.start();
		ca2.start();

		CuentaAtrasRunnable car1 = new CuentaAtrasRunnable("CR1", 10);
		CuentaAtrasRunnable car2 = new CuentaAtrasRunnable("CR2", 5);
		// crea nuevo hilo con un runnable
		new Thread(car1).start();
		new Thread(car2).start();

		new Thread(() -> {
			for (int i = 10; i >= 0; i--) {
				System.out.printf("%s: %d ", "Lambdos", i);
			}
		}).start();;

	}

}
