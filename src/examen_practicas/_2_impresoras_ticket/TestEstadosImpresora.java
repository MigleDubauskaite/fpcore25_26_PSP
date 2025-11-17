package examen_practicas._2_impresoras_ticket;

import java.util.ArrayList;
import java.util.List;

public class TestEstadosImpresora {
	
	private static int milis = 300;

	public static void main(String[] args) {
		
		TicketPrinterR ticket1 = new TicketPrinterR("Museo", 5);
		Thread hilo = new Thread(ticket1); 
		
		List<Thread.State> estadosHilo = new ArrayList<>();
		
		System.out.printf("Estado antes de start() → %s %n%n", hilo.getState());
		estadosHilo.add(hilo.getState());
		
		hilo.start();
		System.out.printf("Estado mientras de start() → %s %n%n", hilo.getState());
		estadosHilo.add(hilo.getState());
		
		StringBuilder sb = new StringBuilder();
		while(hilo.isAlive()) {
			sb.append(hilo.getState() + " | ");
			try {
				Thread.sleep(milis /3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			estadosHilo.add(hilo.getState());
		}
		System.out.printf("%n%s%n", sb);
		
		try {
			hilo.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("%nEstado después de start() → %s %n%n", hilo.getState());
		estadosHilo.add(hilo.getState());
		
		System.out.println("ESTADOS: " + estadosHilo);
		System.out.println("Total estados almacenados: " + estadosHilo.size());
		
	}

}
