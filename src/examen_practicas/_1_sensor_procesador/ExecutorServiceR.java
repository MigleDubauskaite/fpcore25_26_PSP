package examen_practicas._1_sensor_procesador;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceR implements Runnable {

	private String nombre;
	private int valor;
	private boolean encendida;
	private static int milis = 300;

	public ExecutorServiceR(String nombre, int valor) {
		this.nombre = nombre != null ? nombre : "Sensor sin nombre";
		this.valor = valor < 10 ? 10 : valor > 100 ? 100 : valor;
		encendida = false;
	}

	public void encender() {

		if (!encendida && valor >= 10) {
			encendida = true;
			
			while (valor > 0) {
				System.out.printf("%s tiene %d %% %n", nombre, valor);
				valor--;
				try {
					Thread.sleep(milis);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			encendida = false;
			System.out.printf("%s no tiene %% (%d) %n", nombre, valor);
		}

	}

	@Override
	public void run() {
		encender();
	}

	public static void main(String[] args) {

		ExecutorServiceR s1 = new ExecutorServiceR("S1", 10);
		ExecutorServiceR s2 = new ExecutorServiceR("S2", 13);
		ExecutorServiceR s3 = new ExecutorServiceR("S3", 20);
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		executor.execute(s1);
		executor.execute(s2);
		executor.execute(s3);
		
		executor.shutdown();

	}

}
