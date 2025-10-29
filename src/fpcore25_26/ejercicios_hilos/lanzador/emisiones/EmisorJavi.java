package fpcore25_26.ejercicios_hilos.lanzador.emisiones;

public class EmisorJavi {
	
	private String nombre;
	private char caracter;
	private long segundos;
	private static long milis = 300;

	private final static String GREEN = "\u001B[32m";
	private final static String RED = "\u001B[31m";
	private final static String RESET = "\u001B[0m";

	public EmisorJavi(String nombre, char caracter, int segundos) {
		this.nombre = nombre;
		this.caracter = caracter;
		this.segundos = segundos;
	}

	public EmisorJavi(char caracter, int segundos) {
		this("sin nombre", caracter, segundos);
	}

	public String getNombre() {
		return nombre;
	}

	public void emite() {
		
//		long tiempoDeEmision = System.currentTimeMillis();
		
		// lo multiplicamos por 1000 para convertirlo a milisegundos
		long timeStampMax = segundos * 1000;
		
		System.out.print(GREEN + caracter + RESET);
		while(System.currentTimeMillis() < timeStampMax) {
			System.out.print(caracter);
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.print(RED + caracter + RESET);
	}

	@Override
	public String toString() {
		return nombre ;
	}

}
