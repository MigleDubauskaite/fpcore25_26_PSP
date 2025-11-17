package examen_practicas._3_cintas_transportadoras;

public class LanzadorCinta implements Runnable {

	private CintaTransportadora cintaTransportadora;

	public LanzadorCinta(CintaTransportadora cintaTransportadora) {
		this.cintaTransportadora = cintaTransportadora;
	}

	@Override
	public void run() {
		cintaTransportadora.mover();
	}

	public static void main(String[] args) {

		LanzadorCinta lanzador = new LanzadorCinta(new CintaTransportadora(5, 10));

		new Thread(lanzador).start();
	}

}
