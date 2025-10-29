package fpcore25_26.ejercicios_hilos.lanzador.emisiones;

public class Emisor {

	private String nombre;
	private char caracter;
	private long segundos;

	private final static String GREEN = "\u001B[32m";
	private final static String RED = "\u001B[31m";
	private final static String RESET = "\u001B[0m";

	public Emisor(String nombre, char caracter, int segundos) {
		this.nombre = nombre;
		this.caracter = caracter;
		this.segundos = segundos;
	}

	public Emisor(char caracter, int segundos) {
		this("sin nombre", caracter, segundos);
	}

	public String getNombre() {
		return nombre;
	}

	public void emite() {
		for (int i = 0; i < segundos; i++) {
			if (i >= segundos - 1)
				System.out.print(RED + caracter + RESET);
			else
				System.out.print(GREEN + caracter + RESET);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String toString() {
		return nombre ;
	}
	
	

}
