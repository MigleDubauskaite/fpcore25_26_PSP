package fpcore25_26.ejercicios_hilos.lanzador.emisiones;

public class LanzadorEmisionesJavi extends Thread {

	private String nombre;
	private EmisorJavi emisor;

	public String getNombre() {
		return nombre;
	}

	public EmisorJavi getEmisor() {
		return emisor;
	}

	public LanzadorEmisionesJavi(String nombre, EmisorJavi emisor) {
		this.nombre = nombre;
		this.emisor = emisor;
	}

	@Override
	public void run() {
		emisor.emite();
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append("Lanzador de emisiones: \n");
		sb.append("====================== \n");
		sb.append("- Nombre: " + nombre + "\n");
		sb.append("- Emisor: " + emisor + "\n");
		sb.append("- Hilo: \n");
		sb.append("	- name: " + getName() + "\n");
		sb.append("	- id: " + getId() + "\n");
		sb.append("	- alive?: " + isAlive() + "\n");
		sb.append("	- state: " + getState() + "\n");
		sb.append("	- prioridad: " + currentThread().getPriority() + "\n");
		sb.append("	- interrumpido?: " + interrupted() + "\n");
		sb.append("	- threadGroup: " + getThreadGroup() + "\n");

		return sb.toString();
	}

}
