package examen_practicas._0_bucles_deletreador;

public class DescubrimientoProgresivo {
	
	private String palabra;
	private static long milis = 300;
	
	public DescubrimientoProgresivo(String palabra) {
		this.palabra = palabra;
	}
	
	public void imprimir() {
		
		System.out.println("Palabra: " + palabra.toUpperCase());
		System.out.println("[" + "-".repeat(palabra.length())+ "]");
		
		char[] letras = palabra.toCharArray();
		
		for (int i = 0; i < palabra.length(); i++) {
			
			System.out.print("[");
			for (int j = 0; j < letras.length; j++) {
				
				try {
					if(i == j) System.out.printf("%s".toUpperCase(), letras[j]);
					else System.out.printf("-");
					Thread.sleep(milis);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			System.out.print("] \n");
			
		}
		System.out.println();
		
	}
	
	public static void main(String[] args) {
		
		DescubrimientoProgresivo d = new DescubrimientoProgresivo("LUNA");
		d.imprimir();
		
		DescubrimientoProgresivo d2 = new DescubrimientoProgresivo("estrellas");
		d2.imprimir();
	}

}
