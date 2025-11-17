package examen_practicas._2_impresoras_ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketPrinterT extends Thread {

	private String texto;
	private int copias;
	private List<String> estados;
	private static long milis = 200;

	public List<String> getEstados() {
		return estados;
	}

	public TicketPrinterT(String texto, int copias) {
		this.texto = texto != null ? texto : "Ticket Desconocido";
		this.copias = copias > 0 ? copias : 1;
		estados = new ArrayList<>();
	}

	public void imprimir() {

		while (copias >= 1) {
			copias--;
			System.out.printf("Quedan %d copias de %s %n", copias, texto);
			estados.add("Nr. Copias: " + copias);
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("Lo sentimos, ya no nos quedan copias de %s... %n", texto);
		estados.add("Impresión finalizada");
	}

	@Override
	public void run() {
		imprimir();
	}

	public static void main(String[] args) {

		TicketPrinterT t1 = new TicketPrinterT("Concierto", 5);
		TicketPrinterT t2 = new TicketPrinterT("Teatro", 4);

		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Estados de t1: " + t1.getEstados());
		System.out.println("Estados de t2: " + t2.getEstados());
	}

}
