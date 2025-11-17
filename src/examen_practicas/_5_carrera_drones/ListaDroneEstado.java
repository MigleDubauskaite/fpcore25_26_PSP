package examen_practicas._5_carrera_drones;

import java.util.ArrayList;
import java.util.List;

public class ListaDroneEstado {
	
	public static void main(String[] args) {
		
		DroneR dron = new DroneR("DRON-D", 58);
		
		Thread hilo = new Thread(dron);
		
		List<Thread.State> estados = new ArrayList<>();
		
		System.out.println(hilo.getState());
		estados.add(hilo.getState());
		
		hilo.start();
		System.out.println(hilo.getState());
		estados.add(hilo.getState());
		
		while(hilo.isAlive()) {
			
			System.out.println(hilo.getState());
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
		System.out.println(hilo.getState());
		estados.add(hilo.getState());
		
		System.out.println("\nESTADOS:");
		estados.forEach(System.out::println);

	}

}
