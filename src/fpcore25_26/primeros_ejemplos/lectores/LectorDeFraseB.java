package fpcore25_26.primeros_ejemplos.lectores;

public class LectorDeFraseB extends Thread {

	private String frase;
	private static int miliSec;

	public LectorDeFraseB(String frase) {
		this.frase = frase;
	}

	public void sacarPalabras() {

		String fraseModificada = frase.replace("  ", " ");
		String[] palabras = fraseModificada.split(" ");
		for (int i = 0; i < palabras.length; i++) {
			System.out.printf("[%s] ", palabras[i]);
			try {
				Thread.sleep(miliSec);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		sacarPalabras();
	}

}
