package examen_practicas._0_bucles_deletreador;

public class LetrasSaltarinas {

	private String palabra;
	private static long milis = 200;
	
	public LetrasSaltarinas(String palabra) {
		this.palabra = palabra;
	}
	
	public void imprimir() {
		
		System.out.println("Palabra: " + palabra.toUpperCase());	
		
		char[] letras = palabra.toCharArray();
		
		for (int i = 0; i < palabra.length(); i++) {
			StringBuilder sb = new StringBuilder();
			
			for (int j = 0; j < letras.length; j++) {
				
				if(i == j) sb.append(letras[j]);
				else sb.append("-");
				
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
		
		LetrasSaltarinas l = new LetrasSaltarinas("SALTO");
		l.imprimir();

	}

}
