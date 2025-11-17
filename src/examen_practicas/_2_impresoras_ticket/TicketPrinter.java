package examen_practicas._2_impresoras_ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketPrinter {

	private String texto;
	private int copias;
	private List<String> estados;
	private static long milis = 200;

	public List<String> getEstados() {
		return estados;
	}

	public TicketPrinter(String texto, int copias) {
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

	public static void main(String[] args) {

		TicketPrinter t1 = new TicketPrinter("Concierto", 5);
		TicketPrinter t2 = new TicketPrinter("Teatro", 4);

		t1.imprimir();
		System.out.println(t1.getEstados());

		System.out.println();
		t2.imprimir();
		System.out.println(t2.getEstados());
	}

}
