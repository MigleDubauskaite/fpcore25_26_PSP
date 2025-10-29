package fpcore25_26.ejercicios_hilos.lanzador.emisiones;

public class PruebaJavi {

	public static void main(String[] args) {

		LanzadorEmisionesJavi l = new LanzadorEmisionesJavi("LANZADOR 1", new EmisorJavi("EMISOR 1", '*', 3));
		LanzadorEmisionesJavi l2 = new LanzadorEmisionesJavi("LANZADOR 2", new EmisorJavi("EMISOR 2", '♪', 3));

		// 1º ESTADO: NEW
		System.out.println(l);
		System.out.println(l2);

		l.start();
		l2.start();

		// 2º ESTADO: RUNNABLE
		System.out.println("\n\n======\nMientras de start()\n======\n");
		System.out.println(l);
		System.out.println(l2);

		try {
			l.join();
			l2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 3º ESTADO: TERMINATED
		System.out.println("\n\n======\nDespués de start()\n======\n");
		System.out.println(l);
		System.out.println(l2);
		
		
		// mirar esta parte para que me de estados 4 y 5
		
		// 4º ESTADO: TIMED_WAITING
		// si lo ponemos a sleep
		System.out.println("\n\n\n\nOTRA PRUEBA");
		
		LanzadorEmisionesJavi otra = new LanzadorEmisionesJavi("LANZADOR 1", new EmisorJavi("EMISOR 1", '*', 3));
		
		for (int i = 0; i < 25; i++) {
			System.out.println(otra);
		}
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(otra);
		
		// 5º ESTADO: BLOCKED
		// si lo ponemos a sleep

	}

}
