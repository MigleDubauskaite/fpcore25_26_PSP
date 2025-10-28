package fpcore25_26.ejercicios_hilos.lanzador.adicionales;

public class Descarga implements Runnable {

	private String nombreArchivo;
	private long milis;

	public Descarga(String nombreArchivo, long milis) {
		this.nombreArchivo = nombreArchivo;
		this.milis = milis;
	}

	@Override
	public void run() {

		System.out.printf("%s iniciando descarga... %n", nombreArchivo);
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("%s descarga completada! %n", nombreArchivo);
	}

}
