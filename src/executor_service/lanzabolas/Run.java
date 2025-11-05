package executor_service.lanzabolas;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Run {

	public static void main(String[] args) {

		Lanzabolas l1 = new Lanzabolas("Lanzador 1");
		Lanzabolas l2 = new Lanzabolas("Lanzador 2");
		Lanzabolas l3 = new Lanzabolas("Lanzador 3");

		// Lo que hace es enviar (o programar) la tarea l1 para que se ejecute en uno de
		// los hilos del pool.

		/*
		 * El ExecutorService crea un conjunto de hilos (en este caso, 3 con
		 * newFixedThreadPool(3)).
		 * 
		 * Cuando usas execute(), le das una tarea (un Runnable o Thread) que debe
		 * ejecutarse.
		 * 
		 * Uno de los hilos libres del pool toma la tarea y ejecuta su método run().
		 */

		System.out.println("=== PRIMER INTENTO ===");

		ExecutorService executor1 = Executors.newFixedThreadPool(3);

		executor1.execute(l1);
		executor1.execute(l2);
		executor1.execute(l3);

		executor1.shutdown();

		try {
			executor1.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		while (!executor1.isTerminated()) { 
//			// bloquea hasta que todos los hilos del primer executor terminen }
//		}

		System.out.println("\n=== SEGUNDO INTENTO ===");

		ExecutorService executor2 = Executors.newFixedThreadPool(1);

		executor2.execute(new Lanzabolas("L1"));
		executor2.execute(new Lanzabolas("L2"));
		executor2.execute(new Lanzabolas("L3"));
		executor2.execute(new Lanzabolas("L4"));
		executor2.execute(new Lanzabolas("L5"));
		executor2.execute(new Lanzabolas("L6"));
		executor2.execute(new Lanzabolas("L7"));
		executor2.execute(new Lanzabolas("L8"));
		executor2.execute(new Lanzabolas("L9"));

		executor2.shutdown();

		try {
			executor2.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("\n=== TERCERO INTENTO ===");

		ExecutorService executor3 = Executors.newFixedThreadPool(9);

		for (int i = 1; i <= 9; i++) {
			executor3.execute(new Lanzabolas("L" + i));
		}

		executor3.shutdown();

		try {
			executor3.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
