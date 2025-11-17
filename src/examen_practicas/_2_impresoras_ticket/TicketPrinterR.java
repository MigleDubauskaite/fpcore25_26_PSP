package examen_practicas._2_impresoras_ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TicketPrinterR implements Runnable {

	private String texto;
	private int copias;
	private List<String> estados;
	private static long milis = 200;

	public List<String> getEstados() {
		return estados;
	}

	public TicketPrinterR(String texto, int copias) {
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

		TicketPrinterR ticket = new TicketPrinterR("Concierto", 5);
		TicketPrinterR ticket2 = new TicketPrinterR("Teatro", 4);
		
		Thread t1 = new Thread(ticket);
		Thread t2 = new Thread(ticket2);

		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Estados de ticket: " + ticket.getEstados());
		System.out.println("Estados de ticket2: " + ticket2.getEstados());
		
		System.out.println("\n\nUTILIZAMOS EXECUTOR SERVICE");
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		TicketPrinterR ticket3 = new TicketPrinterR("Concierto", 4);
		TicketPrinterR ticket4 = new TicketPrinterR("Teatro", 5);
		
		
		executor.execute(ticket3);
		executor.execute(ticket4);
		executor.shutdown();
	}

}
