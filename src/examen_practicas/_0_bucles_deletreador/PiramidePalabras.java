package examen_practicas._0_bucles_deletreador;

public class PiramidePalabras {
	
	private String palabra;
	private static long milis = 300;
	
	public PiramidePalabras(String palabra) {
		this.palabra = palabra;
	}
	
	public void imprimir() {
		
		System.out.println("Palabra: " + palabra.toUpperCase());
		
		char[] letras = palabra.toCharArray();
		
		
		
		for (int i = 0; i < palabra.length(); i++) {
			
			StringBuilder sb = new StringBuilder();
			
			for (int j = 0; j < letras.length; j++) {
				if(i >= j) sb.append(letras[j]);
			}
			System.out.println(sb);
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for (int i = palabra.length() - 1; i > 0; i--) {
			StringBuilder sb = new StringBuilder();
			
			for (int j = 0; j < letras.length; j++) {
				if(i > j) sb.append(letras[j]);
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
		
		PiramidePalabras p = new PiramidePalabras("LUZ");
		p.imprimir();

	}

}
