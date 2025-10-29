package fpcore25_26.ejercicios_hilos.lanzador.emisiones;

public class LanzadorEmisiones extends Thread {

	private String nombre;
	private Emisor emisor;

	public String getNombre() {
		return nombre;
	}

	public Emisor getEmisor() {
		return emisor;
	}

	public LanzadorEmisiones(String nombre, Emisor emisor) {
		this.nombre = nombre;
		this.emisor = emisor;
	}

	public LanzadorEmisiones(String nombre, Emisor emisor, String algo) {
		this.nombre = nombre;
		this.emisor = emisor;
	}

	@Override
	public void run() {
		emisor.emite();
	}

	@Override
	public String toString() {
		return String.format("Lanzador de emisiones: %n============ %n-Nombre: %s %n-Emisor: %s %n-Hilo: "
				+ "%n    -nombre: %s "
				+ "%n    -ID: %d "
				+ "%n    -alive?: %b "
				+ "%n    -state: %s"
				+ "%n    -prioridad: %d"
				+ "%n    -interrumpida: %b"
				+ "%n    -threadGroup: %s", 
				nombre, emisor.toString(), getName(), threadId(), 
				isAlive(), Thread.currentThread().getState(), Thread.MAX_PRIORITY, 
				Thread.interrupted(), Thread.currentThread().getThreadGroup());
	}

	public static void main(String[] args) {
		
		LanzadorEmisiones l = new LanzadorEmisiones("LE1", new Emisor('*', 5));
		System.out.println(l);
		l.start();

	}

}
