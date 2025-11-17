package examen_practicas._4_arqueros_torneo;

public class LanzadorArquero implements Runnable {

	private Arquero arquero;

	public LanzadorArquero(Arquero arquero) {
		this.arquero = arquero;
	}

	@Override
	public void run() {
		arquero.disparar();
	}

	public static void main(String[] args) {

		LanzadorArquero lanzador = new LanzadorArquero(new Arquero("Amanda", 10, 50));
		LanzadorArquero lanzador2 = new LanzadorArquero(new Arquero("Marcus", 5, 30));

		new Thread(lanzador).start();
		new Thread(lanzador2).start();

	}

}
