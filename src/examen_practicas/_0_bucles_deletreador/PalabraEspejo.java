package examen_practicas._0_bucles_deletreador;

public class PalabraEspejo {
	
	private String palabra;
	private static long milis = 300;
	
	public PalabraEspejo(String palabra) {
		this.palabra = palabra;
	}
	
	public void imprimir() {
		
		System.out.println("Palabra: " + palabra.toUpperCase());
		System.out.println("[" + "-".repeat(palabra.length())+ "]");
		
		char[] letras = palabra.toCharArray();
		
		for (int i = palabra.length(); i >= 0 ; i--) {
			
			StringBuilder sb = new StringBuilder();
			
			for (int j = 0; j < letras.length ; j++) {
				if(i > j) sb.append("-"); 
				else sb.append(letras[j]);
			}
			
			System.out.println(sb);
		}
		
	}

	public static void main(String[] args) {
		
		PalabraEspejo p = new PalabraEspejo("SOLAR");
		p.imprimir();

	}

}
