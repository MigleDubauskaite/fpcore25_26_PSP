package fpcore25_26.ejercicios_hilos.botelleros;

public class BotellaJavier {

	private int capacidadMaxima;
	private int capacidadOcupada;
	private char caracter;
	private static long milis;
	
	// bloque estático:
	static {
		milis = 300;
	}

	public BotellaJavier(int capacidadMaxima, char caracter) {
		this.capacidadMaxima = capacidadMaxima <= 0 ? 1 : capacidadMaxima;
		// capacidadOcupada equivale a capacidadMaxima porque vamos a ir vaciandola
		capacidadOcupada = this.capacidadMaxima;
		this.caracter = caracter;
	}

	public void vaciar() {

		while (capacidadOcupada > 0) {
			capacidadOcupada--;
			System.out.print(caracter);
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				System.out.println("ERROR: " + e.getMessage());
				return;
			}
		}
		System.out.println();
	}

	@Override
	public String toString() {
		return String.format("Botella de %c con %d contenido de %d", caracter, capacidadOcupada, capacidadMaxima);
	}

	public static void main(String[] args) {

		BotellaJavier b1 = new BotellaJavier(10, '*');
		System.out.println(b1);
		b1.vaciar();
		System.out.println(b1);
		b1.vaciar();
		
		System.out.println();
		BotellaJavier b2 = new BotellaJavier(4, '·');
		System.out.println(b2);
		b2.vaciar();
		
		System.out.println();
		BotellaJavier b3 = new BotellaJavier(-5, 'x');
		b3.vaciar();
	}
}
