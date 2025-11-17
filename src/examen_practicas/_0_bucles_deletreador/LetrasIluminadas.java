package examen_practicas._0_bucles_deletreador;

public class LetrasIluminadas {
	
	private String palabra;
	private static long milis = 300;
	
	public LetrasIluminadas(String palabra) {
		this.palabra = palabra;
	}
	
	public void imprimir() {
		
		System.out.println("Palabra: " + palabra.toUpperCase());
		
		char[] letras = palabra.toCharArray();
		for (int i = 0; i < palabra.length(); i++) {
			
			StringBuilder sb = new StringBuilder();
			
			for (int j = 0; j < letras.length; j++) {
				
				if(i == j) sb.append(Character.toUpperCase(letras[j]));
				else sb.append(letras[j]);
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

		LetrasIluminadas l = new LetrasIluminadas("casa");
		l.imprimir();
	}

}
