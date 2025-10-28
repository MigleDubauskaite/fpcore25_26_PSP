package fpcore25_26.ejercicios_hilos.lanzador.adicionales;

public class LanzadorFabricaRobot extends Thread {

	private Robot robot;

	public LanzadorFabricaRobot(Robot robot) {
		this.robot = robot;
	}

	@Override
	public void run() {
//		Thread t = new Thread(robot);
//		t.start();
		robot.run();
	}

	public static void main(String[] args) {

		new LanzadorFabricaRobot(new Robot("R1", 100)).start();
		;
		new LanzadorFabricaRobot(new Robot("R2", 150)).start();
		;
		new LanzadorFabricaRobot(new Robot("R3", 200)).start();
		;

	}

}
