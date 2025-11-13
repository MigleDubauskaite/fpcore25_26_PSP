package fpcore25_26.preparacion_examen.luciernagas.segundo_intento;

public class Deletrator {

	private String palabra;
	private static long milis = 500;

	public Deletrator(String palabra) {
		this.palabra = palabra;
	}

	public void deletrear() {

		char[] letras = palabra.toCharArray();

		for (int i = 0; i < palabra.length(); i++) {
			System.out.printf("Deletreando \"%s\": [", palabra);

			StringBuilder sb = new StringBuilder();

			for (int j = 0; j < letras.length; j++) {

				if (i == j) {
					sb.append(letras[j]);
				} else {
					sb.append("-");
				}
			}
			
			System.out.println(sb + "]");
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

	}

}
