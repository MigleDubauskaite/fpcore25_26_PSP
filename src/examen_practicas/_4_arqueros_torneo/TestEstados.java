package examen_practicas._4_arqueros_torneo;

import java.util.ArrayList;
import java.util.List;

public class TestEstados {

	public static void main(String[] args) {

		ArqueroRunnable arquero = new ArqueroRunnable("Sofia", 5, 90);
		
		Thread hilo = new Thread(arquero);
		
		List<Thread.State> estados = new ArrayList<>();
		
		System.out.println("ESTADO ANTES: " + hilo.getState());
		estados.add(hilo.getState());
		
		hilo.start();
		System.out.println("ESTADO DESPUÉS: " + hilo.getState());
		estados.add(hilo.getState());
		
		while(hilo.isAlive()) {
			System.out.println("ESTADO MIENTRAS ES VIVO: " + hilo.getState());
			estados.add(hilo.getState());
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		try {
			hilo.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("ESTADO AL TERMINARLO: " + hilo.getState());
		estados.add(hilo.getState());

		
		System.out.println("ESTADOS: ");
		estados.forEach(System.out::println);
		
	}

}
