package executor_service.lanzabolas;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Lanzabolas extends Thread {

	private String nombre;
	private int id;
	private static int nextID =  1;

	public Lanzabolas(String nombre) {
		this.nombre = nombre;
		id = nextID++;
	}

	private static DateTimeFormatter formatoTiempo = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

	@Override
	public void run() {
		String horaActual = LocalTime.now().format(formatoTiempo);
		System.out.printf("Lanzando bola %d desde %s a las %s %n", id, nombre, horaActual);
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
