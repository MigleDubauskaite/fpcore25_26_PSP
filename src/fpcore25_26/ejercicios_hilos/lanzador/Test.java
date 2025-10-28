package fpcore25_26.ejercicios_hilos.lanzador;

public class Test {

	public static void main(String[] args) {

		Botella b1 = new Botella("B1", 6, '⁜');
		Botella b2 = new Botella("B1", 3, '⁂');
		Botella b3 = new Botella("B1", 8, '♪');
		LanzadorVaciadorBotella lb1 = new LanzadorVaciadorBotella(b1);
		LanzadorVaciadorBotella lb2 = new LanzadorVaciadorBotella(b2);
		LanzadorVaciadorBotella lb3 = new LanzadorVaciadorBotella(b3);

		System.out.println("Estado inicial: ");

		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println();

		lb1.start();
		lb2.start();
		lb3.start();

		try {
			lb1.join();
			lb2.join();
			lb3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("\n\nEstado final: ");
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);

		System.out.println("\n\nOtra manera: ");
		new LanzadorVaciadorBotella(new Botella("A", 5, '$')).start();
		;
		new LanzadorVaciadorBotella(new Botella("B", 4, '*')).start();
		;
		new LanzadorVaciadorBotella(new Botella("C", 3, '-')).start();
		;

	}

}
