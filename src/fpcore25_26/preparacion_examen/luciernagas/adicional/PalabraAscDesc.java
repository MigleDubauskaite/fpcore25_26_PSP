package fpcore25_26.preparacion_examen.luciernagas.adicional;

public class PalabraAscDesc {

	private String palabra;
	private static long milis = 500;

	public PalabraAscDesc(String palabra) {
		this.palabra = palabra;
	}

	private void crecerYDescrecer() {

		//char[] letras = palabra.toCharArray();
		
		for (int i = 0; i < palabra.length(); i++) {
			
			String palabraAsc = palabra.substring(0, i + 1);			
			System.out.println(palabraAsc);
			
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for (int i = 0; i < palabra.length(); i++) {
			
			String palabraDesc = palabra.substring(i, palabra.length() -1);
			System.out.println(palabraDesc);
			
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

//		for (int i = 0; i < palabra.length(); i++) {
//
//			StringBuilder sb = new StringBuilder();
//
//			for (int j = 0; j < letras.length; j++) {
//				if (j <= i)
//					sb.append(palabra.charAt(j));
//			}
//
//			System.out.println(sb);
//
//			try {
//				Thread.sleep(milis);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//
//		}
//
//		for (int i = palabra.length() - 2; i >= 0; i--) {
//
//			StringBuilder sb = new StringBuilder();
//
//			for (int j = 0; j <= i; j++) {
//				sb.append(palabra.charAt(j));
//			}
//
//			System.out.println(sb);
//
//			try {
//				Thread.sleep(milis);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//
}

	public static void main(String[] args) {
		PalabraAscDesc p = new PalabraAscDesc("Solar");
		p.crecerYDescrecer();
	}

}
