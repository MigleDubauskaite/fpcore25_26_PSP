package fpcore25_26.preparacion_examen.luciernagas.adicional;

public class PalabraEspejo {

	private String palabra;
	private static int milis = 300;

	public PalabraEspejo(String palabra) {
		this.palabra = palabra;
	}

	private void reflejarPalabras() {

		for (int i = 1; i <= palabra.length(); i++) {

			StringBuilder sb = new StringBuilder();

			char[] letras = palabra.toCharArray();

			for (int j = letras.length -1; j >= 0; j--) {

				if (j >= i) {
					sb.append("-");

				} else
					sb.append(Character.toUpperCase(palabra.charAt(j)));

			}

			System.out.println(sb);
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	private void salidaPalabra() {

		char[] letras = palabra.toCharArray();

		for (int i = palabra.length() - 1; i >= 0; i--) {

			StringBuilder sb = new StringBuilder();

			for (int j = 0; j < letras.length; j++) {
				if (j < i)
					sb.append("-");
				else
					sb.append(Character.toUpperCase(palabra.charAt(j)));
			}
			System.out.println(sb);
		}

	}

	private void mejorMetodoParaReflejar() {

		for (int i = 0; i < palabra.length(); i++) {

			String guiones = "-".repeat(palabra.length() - i - 1);
			String letras = palabra.substring(0, i + 1).toUpperCase();

			System.out.println(guiones + letras);

			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {
		PalabraEspejo p = new PalabraEspejo("luces");
		p.reflejarPalabras();

		System.out.println();
		System.out.println();

		p.salidaPalabra();

		System.out.println();
		System.out.println();
		p.mejorMetodoParaReflejar();
	}

}
