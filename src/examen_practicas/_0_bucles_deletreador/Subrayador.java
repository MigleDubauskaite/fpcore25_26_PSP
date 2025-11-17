package examen_practicas._0_bucles_deletreador;

public class Subrayador {

	private String palabra;
	private int milis;

	// Constructor
	public Subrayador(String palabra) {
		this.palabra = palabra;
	}

	public void subrayar() {

		int longitudPalabra = palabra.length();

		for (int i = 0; i < palabra.length(); i++) {
			
		    StringBuilder sb = new StringBuilder();
		    StringBuilder lineaSubrayado = new StringBuilder();

		    for (int j = 0; j < palabra.length(); j++) {
		    	
		        // Construye la línea de la palabra
		        sb.append(palabra.charAt(j) + " ");

		        // Construye la línea de subrayado
		        if (j == i) {
		            lineaSubrayado.append('_' + " ");
		        } else {
		            lineaSubrayado.append(' ' + " ");
		        }
		    }

		    System.out.println();
		    System.out.println(sb);
		    System.out.println(lineaSubrayado);

		    try {
		        Thread.sleep(milis);
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		}

	}

	public static void main(String[] args) {

		Subrayador s = new Subrayador("MESA");
		s.subrayar();

	}

}
