package examen_practicas._6_robot_soldador;

public class LanzadorRobot extends Thread {

	private RobotSoldador robot;

	public LanzadorRobot(RobotSoldador robot) {
		this.robot = robot;
	}

	@Override
	public void run() {
		robot.iniciarSoldadura();
	}

	public static void main(String[] args) {

		LanzadorRobot l = new LanzadorRobot(new RobotSoldador("ROBOT", 5));
		l.start();
		
		
		Thread t2 = new Thread(new LanzadorRobot(new RobotSoldador("R", 3)));
		t2.start();

	}

}
