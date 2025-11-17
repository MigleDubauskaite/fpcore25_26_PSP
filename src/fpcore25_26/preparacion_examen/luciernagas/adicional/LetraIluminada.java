package fpcore25_26.preparacion_examen.luciernagas.adicional;

public class LetraIluminada {

	private static final String GREEN = "\u001B[32m";
	private static final String RESET = "\u001B[0m";

	private String palabra;
	private static int milis = 400;

	public LetraIluminada(String palabra) {
		this.palabra = palabra;
	}

	private void iluminarLetra() {

		char[] letras = palabra.toCharArray();

		for (int i = 0; i < palabra.length(); i++) {
			StringBuilder sb = new StringBuilder();

			for (int j = 0; j < letras.length; j++) {
				if (i == j) {
					sb.append(GREEN + Character.toUpperCase(letras[j]) + RESET);
				} else {
					sb.append(Character.toLowerCase(letras[j]));
				}
				try {
					Thread.sleep(milis);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			
			System.out.println(sb);

		}

	}

	public static void main(String[] args) {

		LetraIluminada li = new LetraIluminada("Migle");
		li.iluminarLetra();

		System.out.println();
		LetraIluminada li2 = new LetraIluminada("Arbolito");
		li2.iluminarLetra();

	}

}
