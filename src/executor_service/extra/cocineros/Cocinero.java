package executor_service.extra.cocineros;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.random.RandomGenerator;

public class Cocinero implements Runnable {

	private String nombre;
	private String plato;

	private static final RandomGenerator RANDOM = RandomGenerator.getDefault();

	public Cocinero(String nombre, String plato) {
		this.nombre = nombre;
		this.plato = plato;
	}

	@Override
	public void run() {
		int tiempoPreparacion = RANDOM.nextInt(500, 1000);
		System.out.printf("Cocinero %s preparando %s (%d) %n", nombre, plato, tiempoPreparacion);
		try {
			Thread.sleep(tiempoPreparacion);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		Cocinero c1 = new Cocinero("Juan", "Paella");
		Cocinero c2 = new Cocinero("María", "Tacos");
		Cocinero c3 = new Cocinero("Luis", "Pizza");
		Cocinero c4 = new Cocinero("Ana", "Sushi");

		ExecutorService executor = Executors.newFixedThreadPool(2);

		/*
		 * Qué hace: Crea un pool de tamaño fijo, con un número fijo de hilos (nThreads)
		 * que se reutilizan para ejecutar tareas.
		 * 
		 * Uso típico: Cuando conoces de antemano el número máximo de hilos que quieres
		 * usar.
		 * 
		 * Comportamiento: Si llegan más tareas que hilos disponibles, se ponen en cola
		 * hasta que un hilo quede libre.
		 * 
		 * Los hilos permanecen vivos mientras el pool esté activo.
		 * 
		 * Si lanzas 5 tareas: 3 se ejecutan simultáneamente y las 2 restantes esperan
		 * en la cola.
		 */

		executor.execute(c1);
		executor.execute(c2);
		executor.execute(c3);
		executor.execute(c4);

		executor.shutdown();
		try {
			executor.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("\n\nSingleThreadExecutor");

		ExecutorService executorSingle = Executors.newSingleThreadExecutor();

		/*
		 * Qué hace: Crea un pool con un solo hilo.
		 * 
		 * Uso típico: Cuando quieres que las tareas se ejecuten de forma secuencial,
		 * garantizando orden de ejecución.
		 * 
		 * Comportamiento: Las tareas se ejecutan una tras otra, nunca en paralelo.
		 * 
		 * Muy útil cuando hay operaciones que no deben ejecutarse simultáneamente (ej.
		 * escribir en un archivo compartido).
		 * 
		 * Si lanzas 5 tareas: se ejecutarán en el orden que fueron enviadas.
		 */

		executorSingle.execute(new Cocinero("Juan", "Paella"));
		executorSingle.execute(new Cocinero("María", "Tacos"));
		executorSingle.execute(new Cocinero("Luis", "Pizza"));
		executorSingle.execute(new Cocinero("Ana", "Sushi"));

		executorSingle.shutdown();

		try {
			executorSingle.awaitTermination(20, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("\n\nCachedThreadPool");

		ExecutorService executorCached = Executors.newCachedThreadPool();

		/*
		 * Qué hace: Crea un pool dinámico: Reutiliza hilos existentes si están
		 * disponibles. Crea nuevos hilos según sea necesario si todos los hilos están
		 * ocupados. Elimina hilos que llevan tiempo inactivos (por defecto 60
		 * segundos).
		 * 
		 * Uso típico: Cuando tienes muchas tareas cortas y no sabes cuántas se
		 * ejecutarán al mismo tiempo.
		 * 
		 * Comportamiento: No hay límite fijo de hilos (puede crecer mucho si llegan
		 * muchas tareas simultáneas). Ideal para aplicaciones que tienen picos de
		 * trabajo intermitentes.
		 * 
		 * Si lanzas 10 tareas simultáneas y no hay hilos libres, el pool creará nuevos
		 * hilos para ejecutarlas todas al mismo tiempo.
		 */

		executorCached.execute(c1);
		executorCached.execute(c2);
		executorCached.execute(c3);
		executorCached.execute(c4);
		executorCached.execute(c1);
		executorCached.execute(c3);

		executorCached.shutdown();

		try {
			executorCached.awaitTermination(20, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		/*
		 * FixedThreadPool 
		 * Fijo (nThreads) 
		 * Paralela, limitada 
		 * Cargas conocidas y control de hilos 
		 * 
		 * SingleThreadExecutor 
		 * 1 hilo
		 * Secuencial 
		 * Tareas que requieren orden o exclusividad 
		 * 
		 * CachedThreadPool 
		 * Dinámico 
		 * Paralela, ilimitada 
		 * Muchas tareas cortas o picos intermitentes
		 */

	}

}
