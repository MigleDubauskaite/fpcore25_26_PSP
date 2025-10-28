package fpcore25_26.ejercicios_hilos.lanzador.adicionales;

public class LanzadorDescargas extends Thread {

	private Descarga descarga;

	public LanzadorDescargas(Descarga descarga) {
		super();
		this.descarga = descarga;
	}

	@Override
	public void run() {
		descarga.run();
	}

	public static void main(String[] args) {
		new LanzadorDescargas(new Descarga("Archivo1.zip", 500)).start();
		;
		new LanzadorDescargas(new Descarga("Archivo2.zip", 100)).start();
		;
		new LanzadorDescargas(new Descarga("Archivo3.zip", 300)).start();
		;
	}

}