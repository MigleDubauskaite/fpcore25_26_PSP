package fpcore25_26.preparacion_examen.luciernagas.adicional;

public class RevelacionPalabra {

	private String palabra;
	private static int milis = 600;

	public RevelacionPalabra(String palabra) {
		this.palabra = palabra;
	}

	private void revelarPalabra() {

		char[] letras = palabra.toCharArray();

		for (int i = 0; i < palabra.length(); i++) {

			StringBuilder sb = new StringBuilder();

			for (int j = 0; j < letras.length; j++) {
				if (j <= i) {
					sb.append(palabra.charAt(j));
				} else
					sb.append("-");
			}

			System.out.println(sb);

			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		RevelacionPalabra rp = new RevelacionPalabra("Holi");
		rp.revelarPalabra();
	}

}
