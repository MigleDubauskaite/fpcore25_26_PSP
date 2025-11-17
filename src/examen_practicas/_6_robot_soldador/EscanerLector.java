package examen_practicas._6_robot_soldador;

public class EscanerLector implements Runnable {

	private String codigo;
	private static int milis = 200;

	public EscanerLector(String codigo) {
		this.codigo = codigo;
	}

	public void escanear() {

		char[] contenido = codigo.toCharArray();

		System.out.println("PALABRA: " + codigo.toUpperCase());
		System.out.println("[" + "-".repeat(codigo.length()) + "]");

		for (int i = 0; i < codigo.length(); i++) {

			StringBuilder sb = new StringBuilder();
			sb.append("[");

			for (int j = 0; j < contenido.length; j++) {

				if (j == i)
					sb.append(Character.toUpperCase(contenido[j]));
				else
					sb.append("-");

				try {
					Thread.sleep(milis);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			sb.append("]");
			System.out.println(sb);
		}
		System.out.println();
	}

	@Override
	public void run() {
		escanear();
	}

	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread(new EscanerLector("scan"));
		Thread t2 = new Thread(new EscanerLector("luna"));
		Thread t3 = new Thread(new EscanerLector("fresa"));

		t1.start();
		t1.join();

		t2.start();
		t2.join();

		t3.start();
		t3.join();

	}

}
