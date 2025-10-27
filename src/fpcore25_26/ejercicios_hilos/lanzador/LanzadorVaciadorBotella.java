package fpcore25_26.ejercicios_hilos.lanzador;

public class LanzadorVaciadorBotella extends Thread {
	
	private Botella botella;

	public LanzadorVaciadorBotella(Botella botella) {
		this.botella = botella;
	}

	@Override
	public void run() {
		botella.vaciar();
	}
	
	

}
