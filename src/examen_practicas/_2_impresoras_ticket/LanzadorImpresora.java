package examen_practicas._2_impresoras_ticket;

public class LanzadorImpresora implements Runnable {
	
	/*
	 Esta clase permite que otra clase pueda lanzar impresiones 
	 en nuevos hilos fácilmente
	 */
	
	private TicketPrinter tickerPrinter;
	
	public LanzadorImpresora(TicketPrinter tickerPrinter) {
		this.tickerPrinter = tickerPrinter;
	}

	@Override
	public void run() {
		tickerPrinter.imprimir();
	}
	
	public static void main(String[] args) {
		
		TicketPrinter ticket = new TicketPrinter("Cine", 4);
		TicketPrinter ticket1 = new TicketPrinter("Música", 0);
		
		LanzadorImpresora lanzador1 = new LanzadorImpresora(ticket);
		LanzadorImpresora lanzador2 = new LanzadorImpresora(ticket1);
		
		Thread t1 = new Thread(lanzador1);
		Thread t2 = new Thread(lanzador2);
		
		t1.start();
		t2.start();
		
		// new Thread(new LanzadorImpresora(ticket)).start();
		
	}
	
	

}
