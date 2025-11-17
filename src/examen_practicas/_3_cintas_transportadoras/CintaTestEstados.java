package examen_practicas._3_cintas_transportadoras;

import java.util.ArrayList;
import java.util.List;

public class CintaTestEstados {

	public static void main(String[] args) {

		CintaRunnable cinta = new CintaRunnable(3, 10);

		Thread hilo = new Thread(cinta);

		List<Thread.State> estadosHilo = new ArrayList<>();

		System.out.println("ESTADO ANTES DE START(): " + hilo.getState());
		estadosHilo.add(hilo.getState());

		hilo.start();
		System.out.println("ESTADO DESPUÉS DE START(): " + hilo.getState());
		estadosHilo.add(hilo.getState());

		while (hilo.isAlive()) {
			System.out.println("ESTADO MIENTRAS DE START(): " + hilo.getState());
			estadosHilo.add(hilo.getState());
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		try {
			hilo.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("ESTADO AL ACABAR START(): " + hilo.getState());
		estadosHilo.add(hilo.getState());

		System.out.println("\nESTADOS DE HILO:");
		estadosHilo.forEach(System.out::println);
	}

}
