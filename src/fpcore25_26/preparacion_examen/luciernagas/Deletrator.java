package fpcore25_26.preparacion_examen.luciernagas;

public class Deletrator {

	private String palabra;
	private static int milis = 600;

	public Deletrator(String palabra) {
		this.palabra = palabra;
	}

	private void deletrear() {

		char letras[] = palabra.toCharArray();

		for (int i = 0; i < palabra.length(); i++) {

			StringBuilder sb = new StringBuilder();

			for (int j = 0; j < letras.length; j++) {

				// Muestra solo la letra que está exactamente en la posición i.
				if (j == i)
					sb.append(palabra.charAt(j));
				else
					sb.append("-");
			}

			System.out.printf("Deletreando \"%s\": [%s] %n", palabra, sb);

			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) {

		Deletrator d1 = new Deletrator("hola");
		d1.deletrear();

		System.out.println();

		Deletrator d2 = new Deletrator("Migle Dubauskaite");
		d2.deletrear();

	}

}
