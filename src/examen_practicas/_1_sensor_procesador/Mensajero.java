package examen_practicas._1_sensor_procesador;

public class Mensajero implements Runnable {

	private String mensaje;
	private static int milis = 300;

	public Mensajero(String mensaje) {
		this.mensaje = mensaje;
	}

	public void enviar() {

		char[] letras = mensaje.toCharArray();

		for (int i = 0; i < mensaje.length(); i++) {

			StringBuilder sb = new StringBuilder();

			for (int j = 0; j < letras.length; j++) {
				if (i == j)
					sb.append(letras[i]);
				else
					sb.append("-");
			}
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.printf("%s  -----   [%s] %n", mensaje, sb);
		}

	}

	@Override
	public void run() {
		enviar();
	}

}
