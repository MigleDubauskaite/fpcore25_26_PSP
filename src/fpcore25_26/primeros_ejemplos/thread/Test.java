package fpcore25_26.primeros_ejemplos.thread;

public class Test {

	public static void main(String[] args) {

		CuentaAtras ca1 = new CuentaAtras("C-1", 10);
		CuentaAtras ca2 = new CuentaAtras("C-2", 5);

		System.out.printf("Mismo hilo%n");
		ca1.run();
		ca2.run();

		System.out.printf("%nDistinto hilo%n");
		ca1.start();
		ca2.start();

	}

}
