package fpcore25_26.primeros_ejemplos.lectores;

public class LectorDeFrasesA {

	private String frase;

	public LectorDeFrasesA(String frase) {
		this.frase = frase;
	}

	public void sacarPalabras() {

		String fraseModificada = frase.replace("  ", " ");
		String[] palabras = fraseModificada.split(" ");
		for (int i = 0; i < palabras.length; i++) {
			System.out.printf("[%s] ", palabras[i]);
		}
	}
}
