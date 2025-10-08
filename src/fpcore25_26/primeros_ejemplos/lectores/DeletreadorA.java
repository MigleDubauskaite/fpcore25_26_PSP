package fpcore25_26.primeros_ejemplos.lectores;

public class DeletreadorA {

	private String palabra;

	public DeletreadorA(String palabra) {
		this.palabra = palabra;
	}

	public void deletrear() {

		String palabrModificada = palabra.replace(" ", "");
		char[] letras = palabrModificada.toCharArray();
		for (int i = 0; i < letras.length; i++) {
			System.out.printf("[%c]", letras[i]);
		}
		System.out.print(" ");
	}

	public static void main(String[] args) {
		DeletreadorA d1 = new DeletreadorA("H ello");
		DeletreadorA d2 = new DeletreadorA("Mundo ");
		d1.deletrear();
		d2.deletrear();

	}

}
