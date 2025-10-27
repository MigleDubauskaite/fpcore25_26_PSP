package fpcore25_26.ejercicios_hilos.botelleros.repiticiones;

public class BotellaThread1 extends Thread {

	private String nombre;
	private char caracter;
	private int cantidad;
	private static long milis = 400;

	public BotellaThread1(String nombre, char caracter, int cantidad) {
		this.nombre = nombre;
		this.caracter = caracter;
		this.cantidad = cantidad;
	}

	private void vaciar() {
		while (cantidad > 0) {
			System.out.print(caracter);
			cantidad--;
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		vaciar();
	}

	@Override
	public String toString() {
		return "BotellaThread1 [nombre=" + nombre + ", caracter=" + caracter + ", cantidad=" + cantidad + "]";
	}

	public static void main(String[] args) {

		BotellaThread1 bt1 = new BotellaThread1("BT1", '*', 3);
		BotellaThread1 bt2 = new BotellaThread1("BT2", '^', 6);
		BotellaThread1 bt3 = new BotellaThread1("BT3", '·', 10);
		
		System.out.println(bt1);
		System.out.println(bt2);
		System.out.println(bt3);
		
		bt1.start();
		bt2.start();
		bt3.start();
		
		try {
			bt1.join();
			bt2.join();
			bt3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("\nestado final: ");
		System.out.println(bt1);
		System.out.println(bt2);
		System.out.println(bt3);

	}

}
