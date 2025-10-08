package fpcore25_26.primeros_ejemplos.lectores;

public class Prueba {
	
	public static void main(String[] args) {
		
		System.out.println("PROBAMOS LECTOR DE FRASES CON MONOHILO");
		LectorDeFrasesA l1 = new LectorDeFrasesA("Hola  Mundo");
		LectorDeFrasesA l2 = new LectorDeFrasesA("Arba  prie kokios Ispanijos leidyklos prieinu, tai kalbinu ispaniškai");
		l1.sacarPalabras();
		l2.sacarPalabras();
		
		System.out.println("\n\nPROBAMOS DELETREADOR CON MONOHILO");
		DeletreadorA d1 = new DeletreadorA("H ello");
		DeletreadorA d2 = new DeletreadorA("Mundo ");
		d1.deletrear();
		d2.deletrear();
		
		System.out.println("\n\nPROBAMOS LECTOR DE FRASES CON MULTIHILO");
		LectorDeFraseB lb1 = new LectorDeFraseB("Hola  Mundo");
		LectorDeFraseB lb2 = new LectorDeFraseB("Arba  prie kokios Ispanijos leidyklos prieinu, tai kalbinu ispaniškai");
		lb1.start();
		lb2.start();
		

	}

}
