package fpcore25_26.preparacion_examen.luciernagas.adicional;

public class PalabraAscendente {

	private String palabra;
	private static long milis = 500;

	public PalabraAscendente(String palabra) {
		this.palabra = palabra;
	}

	private void mostrandoCaracterPorCaracter() {

		char[] letras = palabra.toCharArray();

		for (int i = 0; i < palabra.length(); i++) {
			StringBuilder sb = new StringBuilder();
			
			// 1 MANERA
			
			/*
			 * for (int j = 0; j < letras.length; j++) { // 'i' indica cuántas letras de la
			 * palabra se deben mostrar en esta vuelta. // Se añade la letra mientras su
			 * índice (j) sea menor o igual que el índice // actual (i), // es decir,
			 * mientras la posición de la letra esté dentro del número de letras // que
			 * queremos revelar.
			 * 
			 * if (j <= i) sb.append(Character.toUpperCase(palabra.charAt(j))); }
			 */
			
			
			// 2 MANERA
			
			// Substring devuelve las letras desde 0 hasta i (incluida)
			String palabritaPoParte = palabra.substring(0, i + 1);
			
			System.out.println(palabritaPoParte.toUpperCase());
			//System.out.println(sb);
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {

		PalabraAscendente p = new PalabraAscendente("Luz");
		p.mostrandoCaracterPorCaracter();

	}

}
